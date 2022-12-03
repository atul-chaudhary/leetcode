package com.atul.strings;

import java.util.Objects;

public class BuddyStrings {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(buddyStrings(s1, s2));
    }



    public static boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[goal.charAt(i) - 'a']++;
        }

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] > 0) num1++;
            if (arr2[i] > 0) num2++;
            if (arr1[i] != arr2[i]) return false;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) count++;
        }

        //if(count == 0 && num1==1 && num2 == 1) return true;
        boolean flag = true;
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] >= 2) c++;
        }
        if (count == 0 && c >= 1) return true;
        return count == 2 ? true : false;
    }
}