package com.atul;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton s1 = Singleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/file.txt"));
        objectOutputStream.writeObject(s1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/file.txt"));
        Singleton s2 = (Singleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

class Singleton implements Serializable, Cloneable{

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Exception("can not clone this object");
    }
}
