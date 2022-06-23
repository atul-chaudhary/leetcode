package com.atul.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriends {

    static public class Edge {
        int v1;
        int v2;

        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here
        //first working on creating the adj list and taking input
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < k; i++) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            adj.get(v1).add(new Edge(v1, v2));
            adj.get(v2).add(new Edge(v2, v1));
        }
        //completed the creation of adj list
        ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                ArrayList<Integer> curr = new ArrayList<>();
                findComp(adj, vis, i, curr);
                comp.add(curr);
            }
        }
        ArrayList<String> finalResult = new ArrayList<>();
        for (int i = 0; i < comp.size(); i++) {
            for (int j = i+1; j < comp.size(); j++) {

            }
        }

        System.out.println(comp);
    }

    private static void findComp(ArrayList<ArrayList<Edge>> graph, boolean[] vis, int node, ArrayList<Integer> comp) {
        vis[node] = true;
        comp.add(node);
        for (Edge edge : graph.get(node)) {
            if (vis[edge.v2] == false) {
                findComp(graph, vis, edge.v2, comp);
            }
        }
        return;
    }
}
