package com.atul.dfs;

public class NumberOfClosedIslands {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}};
                //{{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
                //{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(arr));
    }

    public static int closedIsland(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !vis[i][j]) {
                    if (solve(arr, i, j, vis, null)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean solve(int[][] arr, int i, int j, boolean[][] vis, Integer pre) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
            return false;
        }

        if(vis[i][j]) return true;
        if (arr[i][j] == 1) {
            return true;
        }
        vis[i][j] = true;
        boolean top = solve(arr, i - 1, j, vis, arr[i][j]);
        //if(!top) return false;
        boolean bottom = solve(arr, i + 1, j, vis, arr[i][j]);
        //if(!bottom) return false;
        boolean left = solve(arr, i, j + 1, vis, arr[i][j]);
        //if (!left) return false;
        boolean right = solve(arr, i, j - 1, vis, arr[i][j]);
        //if (!right) return false;


        //vis[i][j] = false;
        if (top && bottom && left && right) return true;
        else return false;
    }
}
