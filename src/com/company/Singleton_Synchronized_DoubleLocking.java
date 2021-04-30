package com.company;

public class Singleton_Synchronized_DoubleLocking {

    private static Singleton_Synchronized_DoubleLocking instance;

    private Singleton_Synchronized_DoubleLocking(){}


    public static Singleton_Synchronized_DoubleLocking getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (Singleton_Synchronized_DoubleLocking.class) {
                if(instance == null){
                    instance = new Singleton_Synchronized_DoubleLocking();
                }
            }
        }
        return instance;
    }

}