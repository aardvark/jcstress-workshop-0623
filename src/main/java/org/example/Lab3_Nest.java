package org.example;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressMeta;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.III_Result;

import java.util.concurrent.atomic.AtomicInteger;

@Outcome(id = "\\d, \\d, 8", expect = Expect.ACCEPTABLE, desc = "Expected result.")
public class Lab3_Nest {
  @JCStressTest
  @JCStressMeta(Lab3_Nest.class)
  @State
  public static class Use_Volatile {
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

  @JCStressTest
  @JCStressMeta(Lab3_Nest.class)
  @State
  public static class Use_Atomic {

    public AtomicInteger v = new AtomicInteger(0);

    @Actor
    public void actor1(III_Result r) {
      r.r1 = v.addAndGet(3);
    }

    @Actor
    public void actor2(III_Result r) {
      r.r2 = v.addAndGet(5);
    }

    @Arbiter
    public void arbiter(III_Result r) {
      r.r3 = v.get();
    }
  }
}
