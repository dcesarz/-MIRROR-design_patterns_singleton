package com.company;

// Problem serializacji i deserializacji obiektów klasy Singleton

// CODE/THEORY REF 1: https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
// CODE/THEORY REF 2: https://www.baeldung.com/java-singleton
// CODE/THEORY REF 3: https://amiyasahu.github.io/singleton-class-per-thread-in-java.html

// SINGLETON_1 + SERIALIZATION + READRESOLVE

import java.io.Serializable;

public class Singleton_3 implements Serializable{

    public int val;
    private static final long serialVersionUID = -324554545465656776L;

    private static class Singleton_3_Helper{
        private static final Singleton_3 inst = new Singleton_3();
    }

    public static Singleton_3 getInstance(){
        return Singleton_3_Helper.inst;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
