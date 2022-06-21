package com.atul.graph;

import java.util.ArrayList;

public class GetNoOfComponentInGraph {
    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {0},
                {3},
                {2},
                {5, 6},
                {4, 6},
                {4, 5}
        };
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                ArrayList<Integer> current = new ArrayList<>();
                dfs(i, graph, current, vis);
                result.add(current);
            }
        }
        System.out.println(result);
    }

    private static void dfs(int node, int[][] graph, ArrayList<Integer> current, boolean[] vis) {
        current.add(node);
        vis[node] = true;

        for (Integer i : graph[node]) {
            if (!vis[i]) {
                dfs(i, graph, current, vis);
            }
        }
    }
}
