package com.atul.dynamic_programming;

import java.util.Arrays;

public class CoinChangeMinWays {
    public static void main(String[] args) {
        //{2,5,10,1};//
//        int[] arr = {2,5,10,1};
//        int sum = 27;
//        int n = arr.length;
//        int[][] dp = new int[n + 1][sum + 1];
//        for (int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//        System.out.println(coinChangeMemo(arr, sum, arr.length,  dp,0));
//        System.out.println(min);
//        System.out.println();
//        System.out.println(solveRec(arr, sum, arr.length, 0));
//        System.out.println(minRec);
    }

    public static int Dp(int[] arr, int sum, int[][] dp){
        for(int i=0;i<= sum;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<= arr.length;i++){
            dp[i][0] = 0;
        }

        int i=1;
//        for (int j = 1;  j<= sum;j++){
//            if(j % arr[j-1])
//        }
        return 0;
    }

    public static int min = Integer.MAX_VALUE;
    public static int solve(int[] arr, int sum, int n, int count, int[][] dp) {
        if (sum == 0) {
            min = Math.min(min, count);
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        if (arr[n - 1] <= sum) {
            dp[n][sum] = solve(arr, sum - arr[n - 1], n, count + 1, dp) + solve(arr, sum, n - 1, count, dp);
            return dp[n][sum];
        } else {
            dp[n][sum] =solve(arr, sum, n - 1, count, dp);
            return dp[n][sum];
        }
    }

    public static int coinChangeMemo(int[] arr, int sum, int n, int[][] dp, int count){
        if(sum==0){
            min = Math.min(min, count);
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        if(arr[n-1] <= sum){
            dp[n][sum] = coinChangeMemo(arr, sum - arr[n-1], n, dp, count+1) + coinChangeMemo(arr, sum, n-1, dp, count);
            return dp[n][sum];
        }else{
            dp[n][sum] = coinChangeMemo(arr,sum, n-1, dp, count);
            return dp[n][sum];
        }
    }

    public static int minRec = Integer.MAX_VALUE;
    public static int solveRec(int[] arr, int sum, int n, int count){
        if(sum == 0){
            minRec = Math.min(minRec, count);
            return 1;
        }
        if(n ==0){
            return 0;
        }

        if(arr[n-1] <= sum){
            return solveRec(arr, sum - arr[n-1], n, count+1) +
                    solveRec(arr, sum, n-1, count);
        }else{
            return solveRec(arr, sum, n -1, count);
        }
    }

}
