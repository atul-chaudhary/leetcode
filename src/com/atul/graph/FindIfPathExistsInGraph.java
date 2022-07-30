package com.atul.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindIfPathExistsInGraph {
   static class Edge {
        int v1;
        int v2;

        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
   }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};//{{0, 1}, {1, 2}, {2, 0}};
        int src = 0;
        int dest = 5;
        boolean[] vis = new boolean[3];
        int n = 6;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph.get(v1).add(new Edge(v1,v2));
            graph.get(v2).add(new Edge(v2, v1));
        }
        for (ArrayList<Edge> e: graph){
            System.out.println(e);
        }
        System.out.println(validPath(graph, 0, dest, vis));
    }

    private static boolean validPath(ArrayList<ArrayList<Edge>> edges, int src, int dest, boolean[] vis){
        if(src==dest){
            return true;
        }

        vis[src] = true;
        for(Edge it: edges.get(src)){
            if(vis[it.v2] == false){
                boolean result = validPath(edges, it.v2, dest, vis);
                if(result){
                    return true;
                }
            }
        }

        return false;
    }
}
