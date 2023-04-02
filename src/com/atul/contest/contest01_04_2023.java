package com.atul.contest;


import java.util.*;

public class contest01_04_2023 {
    public static void main(String[] args) {

    }

    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> map = new HashMap<>();
        int n = chars.length();
        for (int i = 0; i < n; i++) {
            char ch = chars.charAt(i);
            map.put(ch, vals[i]);
        }

        int m = s.length();
        int ans = Integer.MIN_VALUE;
        int maxValue = 0;
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            int val = map.getOrDefault(ch, ch - 'a' + 1);
            maxValue = Math.max(maxValue + val, val);
            ans = Math.max(ans, maxValue);
        }
        return ans;
    }

    public static int minNumber(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num1 = nums1[i];
                int num2 = nums2[j];
                if (num1 == num2) {
                    small = Math.min(small, num1);
                } else {
                    String str1 = num1 + "" + num2;
                    String str2 = num2 + "" + num1;
                    small = Math.min(small, Math.min(Integer.parseInt(str1), Integer.parseInt(str2)));
                }
            }
        }
        return small;
    }


    public static int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        System.out.println(graph + "<<");
        int len = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i] == false) {
                int temp = solve(graph, vis, i, n);
                System.out.println("<<>>" + temp);
                if (temp != -1) {
                    len = Math.min(len, temp);
                }
            }
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }

    private static int solve(List<List<Integer>> graph, boolean[] vis, int cur, int n) {
        Queue<Integer> pq = new LinkedList<>();
        int[] dist = new int[n];
        pq.offer(cur);
        vis[cur] = true;
        while (!pq.isEmpty()) {
            int node = pq.poll();
            for (int it : graph.get(node)) {
                if (vis[it] == false) {
                    pq.offer(it);
                    dist[it] = dist[it] + 1;
                    vis[it] = true;
                } else if (node != it) {
                    return dist[it] + dist[node] + 1;
                }
            }
        }
        return -1;
    }
}
