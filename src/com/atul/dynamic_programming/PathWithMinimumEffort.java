package com.atul.dynamic_programming;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] arr = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(arr));
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        boolean[][] vis = new boolean[n][n];
        return solve(heights, 0 ,0, n, 0, vis);
    }

    static int result = 0;
    private static int solve(int[][] arr, int i, int j, int n, int prev, boolean [][] vis){
        if(i == n-1 && j == n-1){
           result = Math.max(result, Math.abs(result-prev));
           return result;
        }

        if(i >= n || j >= n || vis[i][j]) return Integer.MAX_VALUE;

        vis[i][j] = true;
        int cur = Math.abs(arr[i][j] - prev);
        prev = Math.max(prev, cur);
        int up = solve(arr, i -1, j, n, prev, vis);
        int down = solve(arr, i+1, j, n, prev, vis);
        int left = solve(arr, i, j-1, n, prev, vis);
        int right = solve(arr, i, j+1, n, prev, vis);
        vis[i][j] = false;
        return result;
    }
}
