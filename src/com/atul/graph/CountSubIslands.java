package com.atul.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {
    public static void main(String[] args) {
        int[][] grid1 = {{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}};//{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};//{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands(grid1, grid2));
    }


    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1 && grid1[i][j] == 1 && vis[i][j] == false) {
                    if (solve(grid1, grid2, i, j, vis)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean solve(int[][] grid1, int[][] grid2, int i, int j, boolean[][] vis) {
        int n = grid1.length;
        int m = grid1[0].length;
        vis[i][j] = true;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(i, j));
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        boolean flag = true;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int x = p.i;
            int y = p.j;
            for (int k = 0; k < 4; k++) {
                int xtemp = xcor[k] + x;
                int ytemp = ycor[k] + y;
                if (xtemp >= 0 && xtemp < n && ytemp >= 0 && ytemp < m && !vis[xtemp][ytemp] && grid2[xtemp][ytemp] == 1) {
                    pq.offer(new Pair(xtemp, ytemp));
                    vis[xtemp][ytemp] = true;
                    if (grid1[xtemp][ytemp] == 0) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }
}
