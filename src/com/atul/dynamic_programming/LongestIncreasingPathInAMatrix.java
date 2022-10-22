package com.atul.dynamic_programming;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] arr =  {{3,4,5},{3,2,6},{2,2,1}};
        //System.out.println(solve(arr,2,1, 0, -1));
        System.out.println(longestIncreasingPath(arr));
    }

    public static int longestIncreasingPath(int[][] arr) {
        int n = arr.length;
        int m =  arr[0].length;
        int max = 0;
        Integer[][] dp = new Integer[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ans = solve(arr, i, j, 0, -1, dp);
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    private static int solve(int[][] arr, int i, int j, int count, int prev, Integer[][] dp){
        if(i < 0 || i >= arr.length || j < 0 || j>= arr[0].length || prev >= arr[i][j]){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int[] xcor = {1,-1,0,0};
        int[] ycor = {0,0,-1,1};
        int max = 0;
        for(int k=0;k<4;k++){
            int xtemp = xcor[k] +i;
            int ytemp = ycor[k] + j;
            int ans = 1 + solve(arr, xtemp, ytemp, count+1, arr[i][j], dp);
            max = Math.max(max, ans);
        }
        return dp[i][j] = max;
    }
}
