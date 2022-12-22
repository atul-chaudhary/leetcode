package com.atul.graph;

import java.util.*;

public class PossibleBipartition {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        int n = 5;
        System.out.println(possibleBipartition(n, edges));
    }

    public static boolean possibleBipartition(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n+1];
        int[] color = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            color[i] = -1;
        }
        for(int i=1;i<=n;i++){
            if(vis[i] == false) {
                if (solve(adj, color, vis,i) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(List<List<Integer>> adj, int[] color, boolean[] vis,int node){
        Queue<Integer> pq = new LinkedList<>();
        color[node] = 1;
        vis[node] = true;
        pq.offer(node);
        while (!pq.isEmpty()) {
            int parent = pq.poll();
            for (int adjNode : adj.get(parent)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[parent];
                    vis[adjNode] = true;
                    pq.offer(adjNode);
                }else if(color[adjNode] == color[parent]){
                    return false;
                }
            }
        }
        return true;
    }
}
