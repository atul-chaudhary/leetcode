package com.atul.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};//{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    static class DisJointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        public DisJointSet(int n){
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
                rank.add(0);
            }
        }

        int findUParent(int num){
            if(num == parent.get(num)) return num;
            int up = findUParent(parent.get(num));
            parent.set(num, up);
            return up;
        }

        void unionBySize(int u, int v){
            int pu = findUParent(u);
            int pv = findUParent(v);
            if(pu == pv) return;

            if(size.get(pu) < size.get(pv)){
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            }else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisJointSet ds = new DisJointSet(n);
        for(int [] row : edges){
            int u = row[0];
            int v = row[1];
            int pu = ds.findUParent(u);
            int pv  = ds.findUParent(v);

            if(pu == pv) return row;

            ds.unionBySize(row[0], row[1]);
        }
        return new int[2];
    }

    public static int[] findRedundantConnectionopt(int[][] edges) {
        int n = edges.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String str = edges[i][0] + "|" + edges[i][1];
            map.put(str, i);
        }
        int[] degree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            degree[u]++;
            degree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] result = null;
        int index = -1;
        for (int i = 0; i <= n; i++) {
            if (degree[i] > 2) {
                List<Integer> temp = adj.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    if (degree[temp.get(j)] - 1 >= 1) {
                        String s = i + "|" + temp.get(j);
                        if (map.containsKey(s) && map.get(s) > index) {
                            index = map.get(s);
                            result = new int[]{i, temp.get(j)};
                        } else {
                            String s2 = temp.get(j)+"|"+i;
                            if(map.containsKey(s2) && map.get(s) > index){
                                index = map.get(s2);
                                result = new int[]{temp.get(j), i};
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
