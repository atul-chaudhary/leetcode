package com.atul.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(maxDistanceOpt(grid));
    }

    public static int maxDistanceOpt(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> pq = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    pq.offer(new Pair(i, j));
                }
            }
        }
        if (count == 0) return -1;
        if (count == n * m) return -1;
        int ans = 0;
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            int size = pq.size();
            ans++;
            for (int i = 0; i < size; i++) {
                Pair node = pq.poll();
                int x = node.x;
                int y = node.y;

                for (int j = 0; j < 4; j++) {
                    int newX = xcor[j] + x;
                    int newY = ycor[j] + y;
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        pq.offer(new Pair(newX, newY));
                    }
                }
            }
        }
        return ans - 1;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        List<Pair> list = new ArrayList<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(new Pair(i, j));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int count = Integer.MAX_VALUE;
                    for (int k = 0; k < list.size(); k++) {
                        int num = Math.abs(i - list.get(k).x) + Math.abs(j - list.get(k).y);
                        count = Math.min(count, num);
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

}
