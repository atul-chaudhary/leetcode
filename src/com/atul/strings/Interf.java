package com.atul.strings;

public interface Interf {
        public void m2();

        default void m1() {
            System.out.println("default method");
        }
}
