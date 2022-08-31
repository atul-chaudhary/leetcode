package com.atul.dynamic_programming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {3,7,4,5};
        int n = arr.length;;
        Integer[][] dp = new Integer[n][n];
        System.out.println(solve(arr, 1, arr.length-1, dp));
        System.out.println(solveTab(arr));
    }

    private static int solveTab(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = n-1; i >= 1 ; i--) {
            for (int j = i+1; j < n; j++) {
                int ans = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int temp =  dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j];
                    ans = Math.min(ans, temp);
                }
                dp[i][j] = ans;
            }
        }

        return dp[1][n-1];
    }


    private static int solve(int[] arr, int i, int j, Integer[][] dp){
        if(i >=j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = solve(arr, i, k, dp) + solve(arr, k+1, j, dp) + arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans, temp);
        }
        return dp[i][j] = ans;
    }
}
