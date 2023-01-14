package com.atul.graph;

import java.util.ArrayList;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {
    public static void main(String[] args) {
        int[] parent = {-1, 0};
        String S = "mm";
        System.out.println(longestPathOpt(parent, S));
    }

    public static int longestPathOpt(int[] parent, String s) {
        int n = parent.length;
        if(n==1) return 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) continue;
            int u = i;
            int v = parent[i];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        solve(adj, 0, -1, s);
        return ans;
    }

    static int ans = 0;
    private static int solve(List<List<Integer>> adj, int node, int parent, String str) {
        int max = 0;
        int secondMax = 0;
        for (int it : adj.get(node)) {
            if (parent == it) continue;

            int longest = solve(adj, it, node, str);
            if (str.charAt(it) == str.charAt(node)) continue;
            if (longest > max) {
                secondMax = max;
                max = longest;
            } else if (longest > secondMax) {
                secondMax = longest;
            }
        }
        ans = Math.max(ans, max + secondMax + 1);
        return max + 1;
    }
}
