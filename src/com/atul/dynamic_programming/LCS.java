package com.atul.dynamic_programming;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String a = "absced";
        String b = "abc";
        int[][] dp = new int[a.length()+1][b.length()+1];
//        for (int[] row : dp){
//            Arrays.fill(row, -1 );
//        }
        System.out.println(lcsDp(a, b, a.length(), b .length(), dp));
    }

    public static int lcsDp(String a, String b, int n, int m, int[][] dp){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lcs(String a, String b, int n, int m, int[][] dp){
        if(n ==0 || m==0){
            return 0;
        }
        if(dp[n][m] != - 1){
            return dp[n][m];
        }

        if(a.charAt(n-1) == b.charAt(m-1)){
            dp[n][m] = 1+ lcs(a,b, n-1, m-1, dp);
            return dp[n][m];
        }else{
            dp[n][m] = Math.max(lcs(a, b, n, m-1, dp), lcs(a, b, n-1, m,dp));
            return dp[n][m];
        }
    }

    public static int lcsRecursive(String a, String b, int n, int m){
        if(n ==0 || m==0){
            return 0;
        }

        if(a.charAt(n-1) == b.charAt(m-1)){
            return 1+ lcsRecursive(a,b, n-1, m-1);
        }else{
            return Math.max(lcsRecursive(a, b, n, m-1), lcsRecursive(a, b, n-1, m));
        }
    }
}
