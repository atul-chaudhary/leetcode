package com.atul.dfs;


public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(uniquePathsIII(grid));
    }

    public static int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int zero = 0;
        int starti = -1;
        int startj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) zero++;
                if (grid[i][j] == 1) {
                    starti = i;
                    startj = j;
                }
            }
        }
        boolean[][] vis = new boolean[n][m];
        return dfs(grid, starti, startj, vis, zero);
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] vis, int count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || vis[i][j]) {
            return 0;
        }

        if (grid[i][j] == 2) {
            if(count == -1) return 1;
            return 0;
        }

        vis[i][j] = true;
        count--;

        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            int newx = xcor[k] + i;
            int newy = ycor[k] + j;
            ans += dfs(grid, newx, newy, vis, count);
        }
        count++;
        vis[i][j] = false;
        return ans;
    }

    private static boolean isValid(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid.length;
        if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == 0) {
            return true;
        }
        return false;
    }

}
