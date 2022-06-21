package com.atul.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    static class Edge {
        int v1;
        int v2;

        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return "Edge{" +
                     v1 + " "
                     + v2 +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //creating adj list for graph rep
//        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
//        for (int i = 0; i < graph.length; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].length; j++) {
//                adj.get(i).add(new Edge(i, graph[i][j]));
//            }
//            //System.out.println(adj);
//        }
//        System.out.println(adj);
        boolean[] vis = new boolean[graph.length];
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        findAllPath(graph, 0, graph.length-1, vis,temp,res);
        System.out.println(res);
        return null;
    }

    private static void findAllPath(int[][] graph, int src, int dest, boolean[] vis, ArrayList<Integer> psf, ArrayList<ArrayList<Integer>> result) {
        if (src == dest) {
            result.add(new ArrayList<>(psf));
            return;
        }
        vis[src] = true;
        for (Integer edge : graph[src]) {
            if(!vis[edge]){
                psf.add(edge);
                findAllPath(graph, edge, dest, vis, psf, result);
                psf.remove(psf.size()-1);
            }
        }
        vis[src] = false;
    }
}
