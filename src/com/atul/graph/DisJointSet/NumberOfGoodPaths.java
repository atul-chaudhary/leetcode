package com.atul.graph.DisJointSet;

import java.util.*;

public class NumberOfGoodPaths {
    public static void main(String[] args) {
        int[] vals = {1,3,2,1,3};
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        System.out.println(numberOfGoodPaths(vals, edges));
    }

    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        int  n = vals.length;
        DisJointSet ds = new DisJointSet(n);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        TreeMap<Integer, List<Integer>> map  = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(vals[i], new ArrayList<>());
            map.get(vals[i]).add(i);
        }

        boolean[] vis = new boolean[n];

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> lis = entry.getValue();
            for (int u : lis){
                for(int v : adj.get(u)){
                    if(vis[v]){
                        ds.unionBySize(u,v);
                    }
                }
                vis[u] = true;
            }

            List<Integer> parents = new ArrayList<>();
            for(int it : lis){
                int parentFind = ds.findUParent(it);
                parents.add(parentFind);
            }
            Collections.sort(parents);
        }
        System.out.println(map);
        return 0;
    }

    static class DisJointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisJointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }

        int findUParent(int num) {
            if (num == parent.get(num)) {
                return num;
            }
            int up = findUParent(parent.get(num));
            parent.set(num, up);
            return up;
        }

        void unionBySize(int u, int v) {
            int pu = findUParent(u);
            int pv = findUParent(v);
            if (pu == pv) {
                return;
            }
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }
}
