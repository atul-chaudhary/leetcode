package com.atul.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        System.out.println(shortestPathBinaryMatrix(arr, new int[]{0, 1}, new int[]{2, 2}));
    }

    class Node {
        int row;
        int col;
        int steps;

        Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1) {
                return -1;
            }
            int n = grid.length;
            int m = grid[0].length;
            if (n == 1) {
                return 1;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, 1));
            int delrow[] = {1, 1, 0, 1, -1, -1, 0, -1};
            int delcol[] = {1, 0, 1, -1, 1, 0, -1, -1};
            int min = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int row = node.row;
                int col = node.col;
                int steps = node.steps;
                for (int i = 0; i < 8; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 0) {
                        if (nrow == n - 1 && ncol == m - 1) {
                            return steps + 1;
                        } else {
                            queue.add(new Node(nrow, ncol, steps + 1));
                            grid[nrow][ncol] = 1;
                        }
                    }
                }
            }
            return -1;
        }
    }

    static int shortestPathBinaryMatrix(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        return dfs(grid, source[0], source[1], grid.length, grid[0].length, vis, destination, 0);
    }

    static private int dfs(int[][] grid, int i, int j, int n, int m, boolean[][] vis, int[] dest, int count) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || vis[i][j]) {
            return (int) 1e9;
        }

        if (i == dest[0] && j == dest[1]) {
            return count;
        }
        vis[i][j] = true;
        count++;

        int bot = dfs(grid, i + 1, j, n, m, vis, dest, count);
        int top = dfs(grid, i - 1, j, n, m, vis, dest, count);
        int left = dfs(grid, i, j + 1, n, m, vis, dest, count);
        int right = dfs(grid, i, j - 1, n, m, vis, dest, count);
        return Math.min(bot, Math.min(top, Math.min(left, right)));

    }
}
