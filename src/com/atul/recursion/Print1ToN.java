package com.atul.recursion;

public class Print1ToN {
    public static void main(String[] args) {
        print1n(100);
        //printNto1(100);
    }

    public static void print1n(int number){
        if(number==1){
            System.out.println(number);
            return;
        }
        //System.out.println(number);
        print1n(number-1);
        System.out.println(number);
    }

    public static void printNto1(int number){
        if (number < 0 || number == 0) return;
        System.out.println(number);
        printNto1(number-1);
    }
}
