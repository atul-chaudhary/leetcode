package com.atul.dynamic_programming;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int n = s.length();
        int m = t.length();
        Integer[][] dp = new Integer[n+1][m+1];
        //System.out.println(solveMemo(s, t ,n-1, m-1, dp));
        int result = solveTabSpaceOpt(s, t);
        System.out.println(result);
    }

    private static int solveTabSpaceOpt(String s, String t){
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];
        prev[0] = cur[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    cur[j] =  prev[j-1] + prev[j];
                }else{
                    cur[j]  = prev[j];
                }
            }
            prev = Arrays.copyOf(cur, m+1);
        }
        return prev[m];
    }

    private static int solveTab(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j]  = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    private static int solveMemo(String s, String t, int i, int j, Integer[][] dp){
        if(j<0)return 1;
        if(i<0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] =  solveMemo(s, t, i-1, j-1,dp) + solveMemo(s, t, i-1, j, dp);
        }else{
            return dp[i][j] = solveMemo(s, t, i-1, j, dp);
        }
    }

    private int solve(String s, String t, int i, int j){
        if(j<0)return 1;
        if(i<0) return 0;

        if(s.charAt(i) == t.charAt(j)){
            return solve(s, t, i-1, j-1) + solve(s, t, i-1, j);
        }else{
            return solve(s, t, i-1, j);
        }
    }
}
