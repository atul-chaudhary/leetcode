package com.atul.graph;

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        int n = 6;
        System.out.println(findMinHeightTrees(n, edges));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 0) return new ArrayList<>();
        if(n == 1) return Collections.singletonList(1);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        int[] degree = new int[n];
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            degree[u]++;
            degree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(degree[i] == 1){
                pq.offer(i);
                degree[i]--;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int size = pq.size();
            result.clear();
            for (int i = 0; i < size; i++) {
                int cur = pq.poll();
                result.add(cur);
                for(int it : adj.get(cur)){
                    degree[it]--;
                    if(degree[it] == 1){
                        pq.offer(it);
                    }
                }
            }
        }
        return result;
    }

    static class Pair {
        int node;
        int height;

        public Pair(int node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public static List<Integer> findMinHeightTreesopt(int n, int[][] edges) {
        int len = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int height = height(adj, i, n);
            if(map.containsKey(height)){
                List<Integer> res = map.get(height);
                res.add(i);
                map.put(height, res);
            }else {
                List<Integer> res = new ArrayList<>();
                res.add(i);
                map.put(height, res);
            }
        }
        return map.get(map.firstKey());
    }

    private static int height(List<List<Integer>> adj, int node, int n) {
        boolean[] vis = new boolean[n];
        Queue<Integer> pq = new LinkedList<>();
        pq.add(node);
        vis[node] = true;
        int count = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            count++;
            for (int i = 0; i < size; i++) {
                int temp = pq.poll();
                vis[temp] = true;
                for (int it : adj.get(temp)) {
                    if (!vis[it]) {
                        pq.offer(it);
                    }
                }
            }
        }
        return count;
    }
}
