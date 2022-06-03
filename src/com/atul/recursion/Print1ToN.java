package com.atul.recursion;

public class Print1ToN {
    public static void main(String[] args) {
        //print1n(1);
        printNto1(100);
    }

    public static void print1n(int number){
        if(number==0 || number==100) return;
        else
            System.out.println(number);
        print1n(number+1);
    }

    public static void printNto1(int number){
        if (number < 0 || number == 0) return;
        else System.out.println(number);
        printNto1(number-1);
    }
}
