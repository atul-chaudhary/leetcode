package com.atul.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
    public static void main(String[] args) {

    }

    static int timer = 1;
    private static void dfs(List<List<Integer>> adj, int node, int parent,boolean[] vis, int[] tin, int[] low, List<List<Integer>> result){
        vis[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == false){
                dfs(adj, it, node, vis, tin, low, result);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] > tin[node]){
                    result.add(Arrays.asList(it, node));
                }
            }else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> result = new ArrayList<>();
        dfs(adj, 0, -1, vis, tin, low, result);
        return result;
    }
}
