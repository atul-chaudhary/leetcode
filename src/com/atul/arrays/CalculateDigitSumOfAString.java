package com.atul.arrays;

public class CalculateDigitSumOfAString {
    public static void main(String[] args) {
        String str = "1234";
        int k = 2;
        System.out.println(digitSum(str, k));
    }

    public static String digitSum(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return s;
        }
        int cur = 0;
        String curStr = "";
        String finalStr = "";
        for (int i = 0; i < n; i++) {
            curStr += s.charAt(i);
            cur++;

            if (cur == k || i == n - 1) {
                finalStr += String.valueOf(solve(curStr));
                System.out.println(">>>" + finalStr);
                cur = 0;
                curStr = "";
            }
        }
        return digitSum(finalStr, k);
    }

    private static int solve(String str) {
        int n = str.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return result;
    }
}
