package com.atul.dynamic_programming;

public class LongesCommonSubString {
    public static void main(String[] args) {
        String s  = "absc";
        String b = "abc";
        System.out.println(LongestCommonSubString(s, b, s.length(), b.length(), 0));
    }

    public static int LongestCommonSubString(String x, String y, int m, int n, int curr_max) {
        if (m == 0 || n == 0) return curr_max;

        if (x.charAt(m - 1) == y.charAt(n - 1))
            return LongestCommonSubString(x, y, m - 1, n - 1, curr_max + 1);

        return Math.max(LongestCommonSubString(x, y, m - 1, n, 0), LongestCommonSubString(x, y, m, n - 1, 0));
    }
}
