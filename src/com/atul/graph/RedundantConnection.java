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

    public static int[] findRedundantConnection(int[][] edges) {
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
