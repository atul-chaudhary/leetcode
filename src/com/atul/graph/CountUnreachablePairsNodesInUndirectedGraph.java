package com.atul.graph;

import java.util.*;

public class CountUnreachablePairsNodesInUndirectedGraph {
    public static void main(String[] args) {
        String s = "11100011111";
        System.out.println(checkZeroOnes(s));
        HashMap<Integer, Integer> map = new HashMap<>(12);
    }

    public static boolean checkZeroOnes(String s) {
        int one = solveOne(s);
        int zero = solveZero(s);
        return one > zero ? true : false;
    }

    private static int solveOne(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                ans = Math.max(ans, count);

            } else {
                count = 0;
            }
        }
        return ans;
    }

    private static int solveZero(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                count++;
                ans = Math.max(ans, count);
            }else{
                count = 0;
            }
        }
        return ans;
    }

    static class Pair {
        int node;
        long cost;
        int seat;

        public Pair(int node, long val, int seat) {
            this.node = node;
            this.cost = val;
            this.seat = seat;
        }
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= roads.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        Queue<Pair> pq = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i).size() == 1) {
                pq.offer(new Pair(i, 0, seats));
            }
        }
        long result = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            long cost = pair.cost;
            int seat = pair.seat;
            result += cost;
            for (int it : adj.get(node)) {
                if (seat >= 1) {
                    pq.offer(new Pair(it, cost + 1, seat - 1));
                } else {
                    //pq.offer(new Pair(it, ))
                }
            }
        }
        return 0;
    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] vis, int seats, int[] count) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(adj, node, vis, seats, count);
            }
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }


    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        trav(root, map);
        List<List<Integer>> result = new ArrayList<>();
        for (int it : queries) {
            List<Integer> temp = new ArrayList<>();
            Integer floor = map.floorKey(it);
            Integer ceil = map.ceilingKey(it);
            temp.add(floor == null ? -1 : floor);
            temp.add(ceil == null ? -1 : ceil);
            result.add(temp);
        }
        return result;
    }

    private static void trav(TreeNode root, TreeMap<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        trav(root.left, map);
        trav(root.right, map);
    }

    public static int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                int[] temp = new int[1];
                dfs(adj, vis, i, temp);
                list.add(temp[0]);
            }
        }
        if (list.size() == 1) return 0;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                result += temp * list.get(j);
            }
        }
        return result;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] vis, int node, int[] count) {
        vis[node] = true;
        count[0]++;

        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(adj, vis, it, count);
            }
        }
    }

}
