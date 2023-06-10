package org.example;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.LL_Result;
import org.openjdk.jcstress.infra.results.L_Result;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Lab4_Multimap {

  public static class Multimap_v1 {
    private final Map<String, List<String>> map = new ConcurrentHashMap<>();

    void add(String key, String val) {

    }

    List<String> get(String key) {
      return map.get(key);
    }

  }

  @JCStressTest
  @Outcome(id = {"a"}, expect = Expect.ACCEPTABLE)
  @State
  public static class V1 extends Multimap_v1 {
    @Actor
    public void actor1() {
      add("key", "a");
    }

    @Arbiter
    public void arbiter(L_Result s) {
      s.r1 = get("key").get(0);
    }
  }

  /*

  @JCStressTest
  @Outcome(id = {"a, b", "b, a"}, expect = Expect.ACCEPTABLE)
  @State
  public static class V2 extends Multimap_v2 {
    @Actor
    public void actor1() {
      add("key", "a");
    }

    @Actor
    public void actor2() {
      add("key", "b");
    }

    @Arbiter
    public void arbiter(LL_Result s) {
      s.r1 = get("key").get(0);
      s.r2 = get("key").get(1);
    }
  }

   */
}
