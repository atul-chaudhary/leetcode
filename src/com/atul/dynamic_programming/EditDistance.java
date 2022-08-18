package com.atul.dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";
        Integer[][] dp = new Integer[s.length()+1][t.length()+1];
        System.out.println(solve(s, t, s.length(), t.length(), dp));
        System.out.println(solveTab(s, t));
    }

    private static int solveTab(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1)  == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    private  static int solve(String s, String t, int i, int j, Integer[][] dp){
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i-1) == t.charAt( j-1)) return solve(s, t, i-1, j-1, dp);
        else return 1+ Math.min(solve(s, t, i-1 ,j, dp), Math.min(solve(s, t, i, j-1, dp), solve(s, t, i-1, j-1, dp)));
    }
}
