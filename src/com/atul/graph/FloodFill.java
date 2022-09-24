package com.atul.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = floodFill(arr, sr, sc, color);
        for(int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        solve(image, sr, sc, color, n, m, image[sr][sc], vis);
        return image;
    }


    private static void solve(int[][] arr, int i, int j, int color, int n, int m, int num, boolean[][] vis){
        if(i < 0 || i >= n || j < 0 || j >= m || vis[i][j] || arr[i][j] != num){
            return;
        }
        arr[i][j] = color;
        vis[i][j] = true;

        solve(arr, i-1, j, color, n, m, num, vis);
        solve(arr, i+1, j, color, n, m, num, vis);
        solve(arr, i, j-1, color, n, n, num, vis);
        solve(arr, i, j+1, color, n, m, num, vis);
    }
}
