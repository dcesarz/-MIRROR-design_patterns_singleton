package com.company;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertSame;

class Singleton_SynchronizedTest{

    public static final int THREAD_COUNT = 10000;

    @org.junit.jupiter.api.Test
    public void testingThreadSafety(){
        final Singleton_Synchronized[] singleton = new Singleton_Synchronized[THREAD_COUNT];
        final AtomicInteger count = new AtomicInteger(THREAD_COUNT);
        for(int i=0; i < THREAD_COUNT; i++){
            final int l = i;
            new Thread() {
                public void run() {
                    singleton[l] = Singleton_Synchronized.getInstance();
                    count.decrementAndGet();
                }
            }.start();
        }
        try { Thread.sleep(10); } catch(InterruptedException ex) {
            System.out.println("INTERRUPTED");
        }
        while(count.get() >= 1) {
            try { Thread.sleep(10); } catch(InterruptedException ex) {
                System.out.println("INTERRUPTED");
            }
        }
        for(int i=0;i<THREAD_COUNT - 1;i++) {
            System.out.println("COMPARING THREADS NO " + i + " AND " + (i + 1));
            assertSame(singleton[i], singleton[i + 1]);
            if(singleton[i] == singleton[i + 1]){
                System.out.println("Safe!");
            }
            else{
                System.out.println("Something went wrong...");
            }
        }
    }

}