package com.atul.unkown;

public class Test {
    public static void main(String[] args) {

        int product = 1;

        int a = 1;

        int c = 0;

        while (++product < 3) {

            int b = (1 + 2 * product) % 3;

            c = (2 * product) % 3;

            switch (c) {

                default:

                case 0:

                    a++;

                    break;

                case 1:

                    a += ++a - b-- + ++b;
            }
        }

        System.out.println(a + c);
    }
}

class hack extends Thread {

    Thread threadToInterrupt;

    public void run() {

        threadToInterrupt.interrupt();

    }
}

class hacker {

    public static void main(String[] args) {

        try {

            hack obj = new hack();

            obj.threadToInterrupt = Thread.currentThread();

            obj.start();

            obj.join();
        } catch (InterruptedException ex) {
            System.out.println("The exception has been caught." + ex);
        }
    }
}

class Class1 {

    public static void show() {

        System.out.println("In Class1: :show()");

    }

}

class Class2 extends Class1 {
    public static void show() {

        System.out.println("In Class2::show()");

    }
}

class Main {

    public static void main(String[] args) {
        Class1 b = new Class2();

        b.show();

    }
}