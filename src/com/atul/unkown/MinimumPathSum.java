package com.atul.unkown;

import javax.swing.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Integer[][] dp = new Integer[n][m];
        solve(grid, 0, 0, vis, min, grid[0][0], dp);
        return min[0];
    }

    private static void solve(int[][] grid, int i, int j, boolean[][] vis, int[] min, int cur, Integer[][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            min[0] = Math.min(min[0], cur);
        }

        vis[i][j] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int xtemp = xcor[k] + i;
            int ytemp = ycor[k] + j;
            if (xtemp >= 0 && xtemp < grid.length && ytemp >= 0 && ytemp < grid[0].length && !vis[xtemp][ytemp]) {
                solve(grid, xtemp, ytemp, vis, min, cur + grid[xtemp][ytemp], dp);
            }
        }

        vis[i][j] = false;
    }

    static class Tuple {
        int val;
        int i;
        int j;

        public Tuple(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    public static int minPathSumQ(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(grid[0][0], 0, 0));
        vis[0][0] = true;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Tuple node = pq.poll();
            int val = node.val;
            int x = node.i;
            int y = node.j;
            if (x == n - 1 && y == m - 1) {
                System.out.println("<>>" + val);
                min = Math.min(min, val);
            }

            for (int i = 0; i < 4; i++) {
                int xtemp = xcor[i] + x;
                int ytemp = ycor[i] + y;

                if (xtemp >= 0 && xtemp < n && ytemp >= 0 && ytemp < m && !vis[xtemp][ytemp]) {
                    pq.offer(new Tuple(val + grid[xtemp][ytemp], xtemp, ytemp));
                    vis[xtemp][ytemp] = true;
                }
            }
        }

        return min;
    }

}
