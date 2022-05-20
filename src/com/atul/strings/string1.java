package com.atul.strings;

import java.util.TreeMap;

public class string1 implements Interf {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        System.out.println(arr);
        string1 string1 = new string1();
        string1.m1();
    }

    public static void reverseString(char[] s) {
        int first = 0;
        int last = s.length - 1;
        while (first < last) {
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
    }

    void mymethod(){
        System.out.println("my default method");
    }

    @Override
    public void m2() {

    }
}
