package com.atul.dynamic_programming;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(solve(arr));
        System.out.println(solve(arr, 0, 1, 2, arr.length));
        Integer[][][] dp = new Integer[arr.length+1][2][3];
        System.out.println(solveMemo(arr, 0, 1, 2, arr.length, dp));

        System.out.println(solveTab(arr));
    }

    private static int solveTab(int[] arr){
        int[][][] dp = new int[arr.length+1][2][3];
        int n = arr.length;

        for(int index= n-1;index>=0;index--){
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if(buy == 1){
                        dp[index][buy][cap] = Math.max(
                                -arr[index] + dp[index +1][0][cap],
                                dp[index+1][1][cap]
                        );
                    }else{
                        dp[index][buy][cap] = Math.max(
                                arr[index] + dp[index + 1][1][cap -1],
                                dp[index + 1][0][cap]
                        );
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    private static int solveMemo(int[] arr, int index, int buy, int cap, int n, Integer[][][] dp){
        if(cap == 0) return 0;
        if(index == n) return 0;
        if(dp[index][buy][cap] != null) return dp[index][buy][cap];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(
                    -arr[index] + solveMemo(arr, index +1, 0, cap, n, dp),
                    solveMemo(arr, index + 1, 1, cap, n,dp)
            );
        }else{
            profit = Math.max(
                    arr[index] + solveMemo(arr, index + 1,  1, cap -1, n, dp),
                    solveMemo(arr, index + 1, 0, cap, n, dp)
            );
        }
        return dp[index][buy][cap] = profit;
    }

    private static int solve(int[] arr, int index, int buy, int cap, int n){
        if(cap == 0) return 0;
        if(index == n) return 0;
        int profit = 0;
        if(buy == 1){
            profit = Math.max(
                    -arr[index] + solve(arr, index +1, 0, cap, n),
                    solve(arr, index + 1, 1, cap, n)
            );
        }else{
            profit = Math.max(
              arr[index] + solve(arr, index + 1,  1, cap -1, n),
                    solve(arr, index + 1, 0, cap, n)
            );
        }
        return profit;
    }

    private static int solve(int[] arr) {
        int minLeft = Integer.MAX_VALUE;
        int profitLeft = 0;
        int[] profitL = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            minLeft = Math.min(minLeft, arr[i]);
            profitLeft = Math.max(profitLeft,arr[i]-minLeft);
            profitL[i] = profitLeft;
        }
        int maxRight = Integer.MIN_VALUE;
        int profitRight = 0;
        int[] profitR = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, arr[i]);
            profitRight = Math.max(profitRight, maxRight -  arr[i]);
            profitR[i] = profitRight;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, profitL[i]+ profitR[i]);
        }
        return max;
    }
}
