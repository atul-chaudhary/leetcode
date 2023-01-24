package com.atul.unkown;

import java.util.*;

public class FindTheTownJudge {
    public static void main(String[] args) {
        int n = 3;
        int[][] nums = {{1,3},{2,3}};
        System.out.println(findJudge(n, nums));
    }

    public static int findJudge(int n, int[][] trust) {
        List<HashSet<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] row : trust) {
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
        }
        System.out.println(adj);
        int town = -1;
        for (int i=1;i<=n;i++) {
            if (adj.get(i).isEmpty()) {
                town = i;
            }
        }
        if (town == -1) return -1;
        for (int i=1;i<=n;i++) {
            if(i == town) continue;
            if(!adj.get(i).contains(town)) return -1;
        }
        return town;
    }
}
