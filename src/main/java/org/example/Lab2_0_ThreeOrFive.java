package org.example;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.III_Result;

@JCStressTest
@Outcome(id = "3, 5, 8", expect = Expect.ACCEPTABLE, desc = "Expected result.")
@State
public class Lab2_0_ThreeOrFive {

  public volatile int v = 0;

  @Actor
  public void actor1(III_Result r) {
      v = v + 3;
      r.r1 = v;
  }

  @Actor
  public void actor2(III_Result r) {
      v = v + 5;
      r.r2 = v;
  }

  @Arbiter
  public void arbiter(III_Result r) {
    r.r3 = v;
  }
}
