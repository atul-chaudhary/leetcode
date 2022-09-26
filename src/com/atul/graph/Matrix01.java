package com.atul.graph;

import java.util.Arrays;

public class Matrix01 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result = updateMatrix(arr);
        for(int[] row : result) System.out.println(Arrays.toString(row));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] != 0){
                   int res = dfs(mat, i, j, n, m, 0);
                    System.out.println(res);
                    mat[i][j] = res;
                }
            }
        }
        return mat;
    }

    private static int dfs(int[][] mat, int i, int j, int n, int m, int count){
        if(i < 0 || i >= n || j < 0 || j>=m ){
            return 0;
        }

        if(mat[i][j] == 0){
            return count;
        }

        int right = dfs(mat, i, j-1, n, m, count+1);
        int left = dfs(mat, i, j +1, n, m, count+1);
        int top = dfs(mat, i-1, j, n, m , count +1);
        int bottom = dfs(mat, i+1, j, n, m, count+1);

        return Math.min(right, Math.min(left, Math.min(top, bottom)));
    }
}
