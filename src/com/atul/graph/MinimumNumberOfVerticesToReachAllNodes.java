package com.atul.graph;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(isBipartite(arr));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            int m = graph[i].length;
            for (int j = 0; j < m; j++) {
                int u = i;
                int v = graph[i][j];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }

        int[] color = new int[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (!solve(adj, i, color, vis)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(List<Set<Integer>> adj, int node, int[] color, boolean[] vis) {
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(node);
        vis[0] = true;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            for (int it : adj.get(temp)) {
                if (vis[it] == false) {
                    color[it] = 1 - color[temp];
                    vis[it] = true;
                    pq.offer(it);
                } else if (color[it] == color[temp]) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        int m = edges.size();
        for (int i = 0; i < m; i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            inDegree[v]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
