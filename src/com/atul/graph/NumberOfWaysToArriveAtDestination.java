package com.atul.graph;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(countPaths(7, roads));
    }

    static class Pair {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = roads.length;
        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int mod = (int) 1e9 + 7;
        long[] way = new long[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        way[0] = 1;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int wt = pair.wt;

            for (Pair it : adj.get(node)) {
                if (it.wt + wt < dist[it.node]) {
                    dist[it.node] = it.wt + wt;
                    pq.offer(new Pair(it.node, (int) dist[it.node]));
                    way[it.node] = way[node] % mod;
                } else if (it.wt + wt == dist[it.node]) {
                    way[it.node] += way[node] % mod;
                }
            }
        }
        return (int) way[n - 1] % mod;
    }
}
