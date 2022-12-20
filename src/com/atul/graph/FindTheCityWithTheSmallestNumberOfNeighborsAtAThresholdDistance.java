package com.atul.graph;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        int[][] grid = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        System.out.println(findTheCity(4, grid, 4));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    grid[i][j] = (int)1e9;
                }
            }
        }
        for (int[] row : edges) {
            int u = row[0];
            int v = row[1];
            int wt = row[2];
            grid[u][v] = wt;
            grid[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k]+grid[k][j]);
                }
            }
        }

        int ans = -1;
        int curCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(grid[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(curCount  >= count){
                curCount = count;
                ans = i;
            }
        }
        return ans;
    }
}
