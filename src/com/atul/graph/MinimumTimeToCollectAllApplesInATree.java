package com.atul.graph;

import java.util.*;

public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        int n = 7;
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        System.out.println(minTime(n, edges, hasApple));
    }

    static class Pair{
        int val;
        char ch;

        public Pair(int val, char ch) {
            this.val = val;
            this.ch = ch;
        }
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int m = edges.length;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, labels.charAt(i)));
            adj.get(v).add(new Pair(u, labels.charAt(i)));
        }


        return null;
    }

    private static int[] solve(List<List<Pair>> adj, int node, boolean[] vis){
        vis[node] = true;
        return null;
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int noOfApple = 0;
        Map<Integer, Boolean> apple = new HashMap<>();
        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                apple.put(i, true);
                noOfApple++;
            }
        }
        if (noOfApple == 0) return 0;
        int m = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj + "<<>>");
        boolean[] vis = new boolean[n];
        Map<String, Boolean> edgeVis = new HashMap<>();
        int[] result = new int[1];
        solve(adj, 0, -1, edgeVis, vis, apple, result);
        return result[0];
    }

    private static void solve(List<List<Integer>> adj, int node, int parent, Map<String, Boolean> edgeVis, boolean[] vis, Map<Integer, Boolean> apple, int[] result) {
        System.out.println("Node " + node + " parent " + parent);
        vis[node] = true;
        String edge = node + "|" + parent;
        if (apple.containsKey(node)) {
            edgeVis.put(edge, true);
            result[0] += 2;
        }
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                solve(adj, it, node, edgeVis, vis, apple, result);
            }
        }
    }
}
