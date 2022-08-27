package com.atul.contest;

import java.util.Arrays;

public class JavaBackendDeveloper {
    public static void main(String[] args) {
        int[] arr = {3,6,5,6,4};
        System.out.println(solve(arr, 0, -1, arr.length, new Integer[4][5]));
        System.out.println(solveOtp(arr));
    }

    private static  int solveOtp(int[] arr){
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++){
            for(int prev =0 ; prev < i;prev++){
                if(arr[i] % 2 ==0 || arr[prev] % 2 ==0){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
        }

        int ans = 1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private static int solve(int[] arr, int index, int prev, int n, Integer[][] dp) {
        if (index >= n) {
            return 0;
        }
        //if (dp[index][prev + 1] != null) return dp[index][prev+1];
        int nottake = solve(arr, index + 1, prev, n, dp);
        int take = 0;
        if (prev == -1 || arr[index] % 2 == 0 || arr[prev] % 2 == 0 ) {
            take = 1 + solve(arr, index + 1, index, n, dp);
        }
        return /*dp[index][prev+1] =*/ Math.max(nottake, take);
    }
}
