package com.atul.strings;

import java.util.TreeMap;

public class string1 {
    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        reverseString(arr);
        System.out.println(arr);

    }

    public static void reverseString(char[] s) {
        int first = 0;
        int last = s.length -1;
        while(first < last){
            char temp  = s[first];
            s[first] = s[last];
            s[last] = temp;
            first ++;
            last --;
        }
    }
}
