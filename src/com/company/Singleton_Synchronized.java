package com.company;

public class Singleton_Synchronized {

    private static Singleton_Synchronized instance;

    private Singleton_Synchronized(){}

    public static synchronized Singleton_Synchronized getInstance(){
        if(instance == null){
            instance = new Singleton_Synchronized();
        }
        return instance;
    }

}