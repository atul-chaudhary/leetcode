package com.atul.graph;

import java.util.*;

public class FindClosestNodeToGivenTwoNodes {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int n = 4;
        System.out.println(findCheapestPrice(n, edges, src, dst, k));
    }

    static class Pair {
        int j;
        int price;

        public Pair(int j, int price) {
            this.j = j;
            this.price = price;
        }
    }

    static class Tuple {
        int node;
        int price;
        int distance;

        public Tuple(int node, int price, int distance) {
            this.node = node;
            this.price = price;
            this.distance = distance;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int price = flights[i][2];
            adj.get(u).add(new Pair(v, price));
        }
        int[] dist = new int[n];
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(src, 0, 0));
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Tuple pair = pq.poll();
            int node = pair.node;
            int price = pair.price;
            int distance = pair.distance;

            for (Pair it : adj.get(node)) {
                int cost = it.price;
                int child = it.j;
                if (price + cost < dist[child] && 1 + distance <= k+1) {
                    pq.offer(new Tuple(child, price + cost, 1 + distance));
                    dist[child] = price + cost;
                }
            }
        }

        return dist[dst];
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        int sum = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            int cur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                cur += node.val;
                if (node.left != null) {
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            sum = cur;
        }
        return sum;
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) continue;
            adj.get(i).add(edges[i]);
        }
        int[] dist1 = solve(adj, node1, n);
        int[] dist2 = solve(adj, node2, n);
        int min = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == (int) 1e9 || dist2[i] == (int) 1e9) continue;
            int max = Math.max(dist1[i], dist2[i]);
            if (min > max) {
                min = max;
                node = i;
            }
        }
        return node;
    }

    private static int[] solve(List<List<Integer>> adj, int node, int n) {
        Queue<Integer> pq = new LinkedList<>();
        pq.offer(node);
        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[node] = 0;
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            for (int child : adj.get(temp)) {
                if (1 + dis[temp] < dis[child]) {
                    dis[child] = 1 + dis[temp];
                    pq.offer(child);
                }
            }
        }
        System.out.println(Arrays.toString(dis));
        return dis;
    }
}
