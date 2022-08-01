package com.atul.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int n = 3;
        int m = 7;
        int[][]dp = new int[n+1][m+1];
        ArrayList<Integer> list = new ArrayList<>();
        list.remove(0);
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(0, 0, n, m, dp));
    }

    private static int solve(int i, int j, int n, int m, int[][] dp){
        if(i== n-1 && j==m-1){
            return 1;
        }
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = solve(i+1, j, n, m, dp) + solve(i, j+1, n, m,dp);
         return dp[i][j];
    }
}
