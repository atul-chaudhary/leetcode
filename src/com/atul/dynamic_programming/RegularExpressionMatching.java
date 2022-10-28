package com.atul.dynamic_programming;

import java.util.Locale;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        String sb = "";
        System.out.println(sb.length());
        //System.out.println(isMatch(s,p));
    }

    private boolean solveBottomDown(String s, String p, int i, int j) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        //if(i <0 && j >= 0) return fa

        boolean cond = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') ? true : false;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return solveBottomDown(s, p, i, j + 2) || (cond && solve(s, p, i + 1, j));
        } else {
            if (cond){
                return solveBottomDown(s, p, i+1, j+1);
            }else return false;
        }
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

//    public static boolean isMatch(String s, String p) {
//        return solve(s, p, 0, 0);
//    }

    private static boolean solve(String s, String p, int i, int j) {
        if (i >= s.length() && j < p.length()) return false;
        if (j >= p.length() && i < s.length()) return false;
        if (i == s.length() && j == p.length()) return true;

        if (s.charAt(i) == p.charAt(j)) {
            return solve(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '?') {
            return solve(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '*') {
            return solve(s, p, i + 1, j + 1) || solve(s, p, i + 1, j) || solve(s, p, i, j + 1);
        } else if (s.charAt(i) != p.charAt(j)) {
            return false;
        }
        return false;
    }
}
