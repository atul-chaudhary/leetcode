package com.atul.dfs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minimizeTheDifference(arr, 13));
    }

    public static int minimizeTheDifference(int[][] mat, int target) {
        Integer [][] memo = new Integer [mat.length][70 * 70 + 1];
        return solve(mat, target, 0, 0, memo);
    }

    private static int solve(int[][] grid, int target, int row, int sum,Integer [][] dp){
        if(row == grid.length){
            return Math.abs(target - sum);
        }
        if(dp[row][sum] != null) return dp[row][sum];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            ans = Math.min(ans, solve(grid, target, row+1, sum+grid[row][i],dp));
        }

        return dp[row][sum];
    }
}
