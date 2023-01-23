package com.atul.contest;

import java.util.Arrays;

public class Contest22_02_2023 {
    public static void main(String[] args) {
        String s1 = "11";
        String s2 = "00";
        System.out.println(makeStringsEqual(s1, s2));
    }

    public static boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) return true;
        if (s.contains("1") && target.contains("1")) return true;
        return false;
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }

    public static int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (i % 2 == 0) {
                number += num;
            } else {
                number -= num;
            }
        }
        return number;
    }
}
