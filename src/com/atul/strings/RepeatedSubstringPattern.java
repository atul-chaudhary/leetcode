package com.atul.strings;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int idx = (s + s).indexOf(s, 1);
        System.out.println();
        return  idx < s.length();
    }
}
