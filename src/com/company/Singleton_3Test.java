package com.company;

import java.io.*;

class Singleton_3Test {
    @org.junit.jupiter.api.Test
    public void testingSerializationDeserialization() {
        Singleton_3 instance_1 = Singleton_3.getInstance();
        String filename = "serialized.ser";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(instance_1);
            out.close();
            file.close();
            System.out.println("OBJECT SERIALIZED...");
            ObjectInput in = new ObjectInputStream(new FileInputStream("serialized.ser"));
            Singleton_3 instance_2 = (Singleton_3) in.readObject();
            System.out.println("OBJECT DESERIALIZED...");
            if(instance_1.hashCode() == instance_2.hashCode()) {
                System.out.println("Same hashcode, success!");
            }
            else{
                System.out.println("Different hashcode, test failed");
            }
            assert(instance_1.hashCode() == instance_2.hashCode());
        }
        catch(IOException | ClassNotFoundException exception)
        {
            System.out.println("EXCEPTION HAS BEEN CAUGHT");
        }

    }
    @org.junit.jupiter.api.Test
    public void stateTest(){
        Singleton_3 instance_1 = Singleton_3.getInstance();
        instance_1.val = 3;
        String filename = "serialized.ser";
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(instance_1);
            out.close();
            file.close();
            int val1 = instance_1.val;
            System.out.println("OBJECT SERIALIZED...");
            instance_1.val = 5;
            ObjectInput in = new ObjectInputStream(new FileInputStream("serialized.ser"));
            Singleton_3 instance_2 = (Singleton_3) in.readObject();
            int val2 = instance_2.val;
            System.out.println("OBJECT DESERIALIZED...");
            if(val2 == val1) {
                System.out.println("Same value");
            }
            else{
                System.out.println("Different value");
            }
            assert(val2 == val1);
        }
        catch(IOException | ClassNotFoundException exception)
        {
            System.out.println("EXCEPTION HAS BEEN CAUGHT");
        }
    }
}