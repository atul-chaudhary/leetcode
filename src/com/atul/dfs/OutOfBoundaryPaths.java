package com.atul.dfs;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp){
            Arrays.fill(row,-1);
        }
        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        int result= dfs(m, n, startRow, startColumn, maxMove, dp);
        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return result;
    }

    public static int dfs(int n, int m, int i, int j, int max, int[][] dp){
        if(i < 0 || i == n || j < 0 || j == n){
            return 1;
        }
        if (max==0) return 0;

        if(dp [i][j] != -1){
            return dp[i][j];
        }

        return dp[i][j] = dfs(n, m, i+1, j, max -1,dp)
                + dfs(n, m, i-1, j, max -1, dp)
                + dfs(n, m, i, j+1, max -1, dp)
                + dfs(n, m, i,j-1 ,max -1, dp);

    }
}
