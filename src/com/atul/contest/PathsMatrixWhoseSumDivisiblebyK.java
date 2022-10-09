package com.atul.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PathsMatrixWhoseSumDivisiblebyK {
    public static void main(String[] args) {
        int[][] arr = {{5,2,4},{3,0,5},{0,7,2}};
        int k = 3;
        System.out.println(numberOfPaths(arr, k));
    }

    public static int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int result =  solve(0, 0, n, m, dp, 0, 0, grid, k);
        for (int[] row : dp) System.out.println(Arrays.toString(row));
        return result;
    }

    private static int solve(int i, int j, int n, int m, int[][] dp, int sum, int count, int [][] grid, int k){
        if(i== n-1 && j==m-1){
            sum += grid[i][j];
            if(sum % k ==0){
                return 1;
            }
            return 0;
        }
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] =  (solve(i+1, j, n, m, dp, sum+grid[i][j], count, grid, k) + solve(i, j+1, n, m,dp,sum+grid[i][j], count, grid, k)) ;
    }
}
