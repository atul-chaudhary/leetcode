package com.atul.contest;

import java.util.*;

public class Contest15_04_2023 {
    public static void main(String[] args) {
        int[][] edges = {{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};
        Graph graph = new Graph(4, edges);
        System.out.println(graph.shortestPath(3, 2));
        System.out.println(graph.shortestPath(0, 3));
        graph.addEdge(new int[]{1, 3, 4});
        System.out.println(graph.shortestPath(0, 3));
    }

    public static int[] findColumnWidth(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] result = new int[m];
        for (int cols = 0; cols < m; cols++) {
            int cur = 0;
            for (int rows = 0; rows < n; rows++) {
                int num = grid[rows][cols];
                int curlen;
                if (num < 0) {
                    curlen = String.valueOf(Math.abs(num)).length() + 1;
                } else {
                    curlen = String.valueOf(num).length();
                }
                cur = Math.max(cur, curlen);
            }
            result[cols] = cur;
        }
        return result;
    }

    public static long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            arr[i] = max;
        }

        long[] result = new long[n];
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += nums[i] + arr[i];
            result[i] = curr;
        }
        return result;
    }
}

class Graph {
    static class Pair {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    List<List<Pair>> adj = new ArrayList<>();
    boolean isGraphChanged = false;
    int n;

    public Graph(int n, int[][] edges) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
    }

    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];
        adj.get(u).add(new Pair(v, wt));
    }

    public int shortestPath(int node1, int node2) {
        int[] dist = solve(adj, n, node1);
        return dist[node2] == (int) 1e9 ? -1 : dist[node2];
    }

    private static int[] solve(List<List<Pair>> adj, int n, int src) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[src] = 0;
        Queue<Pair> pq = new LinkedList<>();
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = temp.v;
            int wt = temp.wt;
            for (Pair it : adj.get(node)) {
                int newWt = it.wt + wt;
                if (newWt < dist[it.v]) {
                    dist[it.v] = newWt;
                    pq.offer(new Pair(it.v, newWt));
                }
            }
        }
        return dist;
    }
}
