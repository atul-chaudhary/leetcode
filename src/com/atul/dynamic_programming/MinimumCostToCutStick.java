package com.atul.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;

public class MinimumCostToCutStick {
    public static void main(String[] args) {
        int[] cuts = {1,3,4,5};
        int n = 7;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i : cuts){
            arr.add(i);
        }
        arr.add(n);
        Collections.sort(arr);
        int m = cuts.length;
        Integer[][] dp = new Integer[m+1][m+1];
        System.out.println(solve(arr,1, cuts.length, dp));
        System.out.println();
        System.out.println(solveTab(arr, m));
    }

    private static int solveTab(ArrayList<Integer> arr, int m){
        int[][] dp = new int[m+2][m+2];

        for (int i = m; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                if(i > j) continue;
                int ans = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int temp = dp[i][k-1] + dp[k+1][j] + arr.get(j+1) - arr.get(i-1);
                    ans = Math.min(ans, temp);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][m];
    }

    private static int solve(ArrayList<Integer> arr, int i, int j, Integer[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int temp = solve(arr, i, k-1, dp) + solve(arr, k+1, j, dp) + arr.get(j+1) - arr.get(i-1);
            ans = Math.min(ans, temp);
        }
        return dp[i][j] = ans;
    }
}
