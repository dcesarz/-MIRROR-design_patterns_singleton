package com.company;

//  Odporność na współbieżne wykorzystanie kodu z jednoczesnym zachowaniem maksymalnej wydajności

// CODE/THEORY REF 1: https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
// CODE/THEORY REF 2: https://www.baeldung.com/java-singleton
// CODE/THEORY REF 3: https://amiyasahu.github.io/singleton-class-per-thread-in-java.html

// BILL PUGH SINGLETON IMPLEMENTATION

public class Singleton_1 {

    private Singleton_1(){}

    private static class Singleton_1_Helper{
        private static final Singleton_1 inst = new Singleton_1();
    }

    public static Singleton_1 getInstance(){
        return Singleton_1_Helper.inst;
    }

}
