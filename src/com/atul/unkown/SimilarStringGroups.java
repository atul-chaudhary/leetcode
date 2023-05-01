package com.atul.unkown;

import java.util.*;


public class SimilarStringGroups {
    public static void main(String[] args) {
        String[] strs = {"abc", "abc"};
        System.out.println(numSimilarGroups(strs));
    }

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<String, Set<String>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(strs[i], new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (solve(strs[i], strs[j])) {
                    adj.get(strs[i]).add(strs[j]);
                    adj.get(strs[j]).add(strs[i]);
                }
            }
        }

        Map<String, Boolean> vis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            vis.put(strs[i], false);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis.get(strs[i])) {
                dfs(adj, vis, strs[i]);
                count++;
            }
        }
        return count;
    }

    private static void dfs(Map<String, Set<String>> adj, Map<String, Boolean> vis, String node) {
        vis.put(node, true);
        for (String it : adj.get(node)) {
            if (!vis.get(it))
                dfs(adj, vis, it);
        }
    }

    static class Pair {
        char a;
        char b;

        public Pair(char a, char b) {
            this.a = a;
            this.b = b;
        }
    }

    private static boolean solve(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n != m) return false;
        if(a.equals(b)) return true;
        int count = 0;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == b.charAt(i)) continue;
            count++;
            list.add(new Pair(a.charAt(i), b.charAt(i)));
        }

        if (count > 2) return false;
        Pair aPair = list.get(0);
        Pair bPair = list.get(1);
        return aPair.a == bPair.b && bPair.a == aPair.b;
    }
}
