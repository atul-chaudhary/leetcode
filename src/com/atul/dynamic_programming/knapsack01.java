package com.atul.dynamic_programming;

import java.util.Arrays;

public class knapsack01 {
    public static void main(String[] args) {
        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;
        System.out.println(solve(wt, val, wt.length-1,W));
    }

    //gfg
    private static int solve(int[] wt, int[] val, int n, int w){
        if(n==0 || w== 0){
            return 0;
        }

        int notpick = solve(wt, val, n-1, w);
        int pick = 0;
        if(wt[n-1] <= w)
            pick = val[n-1] +  solve(wt, val, n-1, w-wt[n-1]);
        return Math.max(notpick, pick);
    }

}

class TUF{
    //striver
    static int knapsackUtil(int[] wt,int[] val, int ind, int W,int[][] dp){
        if(ind < 0 || W < 0){
            return 0;
        }
        if(dp[ind][W]!=-1)
            return dp[ind][W];
        int notTaken = 0 + knapsackUtil(wt,val,ind-1,W,dp);
        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt,val,ind-1,W-wt[ind],dp);
        return dp[ind][W] = Math.max(notTaken,taken);
    }


    static int knapsack(int[] wt,int[] val, int n, int W){

        int dp[][]= new int[n][W+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return knapsackUtil(wt, val, n-1, W, dp);
    }

    public static void main(String args[]) {

        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "+ knapsack(wt,val,n,W));
    }
}
