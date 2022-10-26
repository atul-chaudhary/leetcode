package com.atul.dynamic_programming;

import java.util.Arrays;

public class Matrix01 {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = updateMatrix(arr);
        for (int[] row : result) System.out.println(Arrays.toString(row));
    }

    public static int[][] updateMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false && arr[i][j] != 0) {
                    result[i][j] = solve(arr, i, j, vis, 0);
                }
            }
        }
        return result;
    }

    private static int solve(int[][] arr, int i, int j, boolean[][] vis, int count) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || vis[i][j]) {
            return (int) 1e9;
        }
        if (arr[i][j] == 0) return count;

        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int xtemp = xcor[k] + i;
            int ytemp = ycor[k] + j;
            int temp = solve(arr, xtemp, ytemp, vis, count + 1);
            min = Math.min(min, temp);
        }
        vis[i][j] = false;
        return min;
    }
}
