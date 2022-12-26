package com.atul.graph.DisJointSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakingALargeIsland {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,1,0},{1,1,0}};
        System.out.println(largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n * m);
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int u = i * m + j;
                    for (int k = 0; k < 4; k++) {
                        int xtemp = xcor[k] + i;
                        int ytemp = ycor[k] + j;
                        if (isValid(xtemp, ytemp, n, m)) {
                            if (grid[xtemp][ytemp] == 1) {
                                int v = xtemp * m + ytemp;
                                ds.unionBySize(u, v);
                            }
                        }
                    }
                }
            }
        }
        int zeros = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    zeros++;
                    int allDirCount = 1;
                    HashSet<Integer> upsca = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int xtemp = xcor[k] + i;
                        int ytemp = ycor[k] + j;
                        if (isValid(xtemp, ytemp, n, m)) {
                            if (grid[xtemp][ytemp] == 1) {
                                int v = xtemp * m + ytemp;
                                int curUp = ds.findUP(v);
                                if(upsca.contains(curUp)) continue;
                                allDirCount += ds.size.get(curUp);
                                upsca.add(curUp);
                            }
                        }
                    }
                    max = Math.max(max, allDirCount);
                }
            }
        }
        if(zeros == 0) return ds.size.get(0);
        return max;
    }

    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        int findUP(int node) {
            if (node == parent.get(node)) return node;
            int up = findUP(parent.get(node));
            parent.set(node, up);
            return up;
        }

        void unionBySize(int u, int v) {
            int pu = findUP(u);
            int pv = findUP(v);
            if (pu == pv) {
                return;
            }
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pv) + size.get(pu));
            }
        }
    }
}
