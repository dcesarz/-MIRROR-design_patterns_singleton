package com.company;

// W programie wielowątkowym, konstrukcja zapewniająca jeden singleton na wątek

// CODE/THEORY REF 1: https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
// CODE/THEORY REF 2: https://www.baeldung.com/java-singleton
// CODE/THEORY REF 3: https://amiyasahu.github.io/singleton-class-per-thread-in-java.html

public class Singleton_4 {

    private Singleton_4(){  }

    private static ThreadLocal<Singleton_4> _threadLocal = ThreadLocal.withInitial(Singleton_4::new);

    public static Singleton_4 getInstance() {
        return _threadLocal.get();
    }

    private static class Singleton_4_Helper{
        private static final Singleton_1 inst = new Singleton_4();
    }

    public static Singleton_4 getInstance(){
        return Singleton_4.Singleton_4_Helper.inst;
    }

}
