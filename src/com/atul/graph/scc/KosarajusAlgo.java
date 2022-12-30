package com.atul.graph.scc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajusAlgo {

    public static void main(String[] args) {
        int[][] edges = {{2, 3}, {0}, {1}, {4}, {}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int[] row : edges) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int it : row) {
                temp.add(it);
            }
            adj.add(temp);
        }
        System.out.println("adj " + adj);
        System.out.println(kosaraju(5, adj));

    }

    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(adj, 0, stack, vis);
            }
        }
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                revAdj.get(v).add(i);
            }
        }
        int scc = 0;
        Arrays.fill(vis, false);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (vis[node] == false) {
                scc++;
                mainDfs(revAdj, node, vis);
            }
        }
        return scc;
    }

    private static void mainDfs(List<List<Integer>> adj, int node, boolean[] vis) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                mainDfs(adj, it, vis);
            }
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> stack, boolean[] vis) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(adj, it, stack, vis);
            }
        }
        stack.push(node);
    }
}
