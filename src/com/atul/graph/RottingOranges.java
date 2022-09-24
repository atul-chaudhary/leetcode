package com.atul.graph;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2 && vis[i][j] == false){
                    solve(grid, i, j, n, m, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private static void solve(int[][] arr, int i, int j, int n, int m, boolean[][] vis){
        if(i<0 || i>=n || j<0 || j >= m || arr[i][j]==0 || arr[i][j] == 2 || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        arr[i][j] = 2;
        solve(arr, i-1, j, n, m, vis);
        solve(arr, i+1, j, n, m, vis);
        solve(arr, i, j-1, n, n, vis);
        solve(arr, i, j+1, n, m, vis);
    }
}
