package com.atul.unkown;

import java.util.*;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        int n = 15;
        int head = 0;
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] time = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(numOfMinutes(n, head, manager, time));
    }

    static class Pair {
        int vert;
        int val;

        public Pair(int vert, int val) {
            this.vert = vert;
            this.val = val;
        }
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            int u = i;
            int v = manager[i];
            int time = informTime[i];
            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }

        boolean[] vis = new boolean[n];
        int result = Integer.MIN_VALUE;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(headID, informTime[headID]));
        vis[headID] = true;
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            result = Math.max(result, node.val);
            for (Pair it : adj.get(node.vert)) {
                if (vis[it.vert] == false) {
                    pq.offer(new Pair(it.vert, it.val + node.val));
                    vis[it.vert] = true;
                }
            }
        }
        return result;
    }
}
