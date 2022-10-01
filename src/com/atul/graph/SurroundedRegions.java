package com.atul.graph;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] arr = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solve(arr);
    }

    public static void solve(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(arr[i][0] == 'O'){
                dfs(arr, i, 0, n, m, vis);
            }

            if(arr[i][m-1] == 'O'){
                dfs(arr, i, m-1, n, m, vis);
            }
        }

        for(int i=0;i<m;i++){
            if(arr[0][i] == 'O'){
                dfs(arr, 0, i, n, m, vis);
            }

            if(arr[n-1][i] == 'O'){
                dfs(arr, n-1, i, n, m, vis);
            }
        }
        for(boolean[] row : vis){
            System.out.println(Arrays.toString(row));
        }

        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 'O' && !vis[i][j]){
                    arr[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(char[][] arr, int i, int j, int n, int m, boolean[][] vis){
        if(i<0 || i>=n || j < 0 || j >= m|| vis[i][j] || arr[i][j] == 'X'){
            return;
        }

        vis[i][j] = true;

        dfs(arr, i-1, j, n, m, vis);
        dfs(arr, i+1, j, n, m, vis);
        dfs(arr, i, j+1, n, m, vis);
        dfs(arr, i, j-1, n, m, vis);
    }
}
