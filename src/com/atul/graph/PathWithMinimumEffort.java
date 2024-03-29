package com.atul.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PathWithMinimumEffort {
    public static void main(String[] args) throws IOException {
         Set<Integer> set = new HashSet<>();
        List<Integer> nums = new ArrayList<>(set);
        int random = (int)(Math.random()*set.size()-1);
        System.out.println(nums.get(random));
    }

    static class Pair {
        int i, j, dis;

        Pair(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }

    public static int minimumEffortPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }
        dist[0][0] = 0;

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        pq.offer(new Pair(0, 0, 0));
        int[] xcor = {1, -1, 0, 0};
        int[] ycor = {0, 0, 1, -1};
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int x = p.i;
            int y = p.j;
            int dis = p.dis;

            for (int i = 0; i < 4; i++) {
                int newx = x + xcor[i];
                int newy = y + ycor[i];
                if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                    int newdis = Math.max(dis, Math.abs(arr[newx][newy] - arr[x][y]));
                    if (newdis < dist[newx][newy]) {
                        dist[newx][newy] = newdis;
                        pq.offer(new Pair(newx, newy, dist[newx][newy]));
                    }
                }
            }
        }
        //for (int[] row : dist) System.out.println(Arrays.toString(row));
        return dist[n - 1][m - 1];
    }
}
