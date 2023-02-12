package com.atul.graph;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        int[][] redEdges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blueEdges = {{1, 2}, {2, 3}, {3, 1}};
        int n = 5;
        System.out.println(Arrays.toString(shortestAlternatingPaths(n, redEdges, blueEdges)));
    }

    static class Pair {
        int val;
        Boolean color; //true for blue  and false for red;

        public Pair(int val, Boolean color) {
            this.val = val;
            this.color = color;
        }
    }

    static class Tuple {
        int val;
        Boolean color;
        int cost;

        public Tuple(int val, Boolean color, int cost) {
            this.val = val;
            this.color = color;
            this.cost = cost;
        }
    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Pair>> adj = new ArrayList<>();
        int[] dis = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dis[i] = (int) 1e9;
        }

        int lenRed = redEdges.length;
        int lenBlue = blueEdges.length;
        for (int i = 0; i < lenRed; i++) {
            int u = redEdges[i][0];
            int v = redEdges[i][1];
            adj.get(u).add(new Pair(v, false));
        }
        for (int i = 0; i < lenBlue; i++) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            adj.get(u).add(new Pair(v, true));
        }

        //src node
        dis[0] = 0;
        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, null, 0));
        HashSet<String> seen = new HashSet<>();
        while (!pq.isEmpty()) {
            Tuple node = pq.poll();
            for (Pair it : adj.get(node.val)) {
                String str = node.val + "|" + it.val + "|" + it.color;
                if (!seen.contains(str) && (node.color == null || node.color == !it.color)) {
                    dis[it.val] = Math.min(dis[it.val], node.cost + 1);
                    seen.add(str);
                    pq.offer(new Tuple(it.val, it.color, node.cost + 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dis[i] == (int) 1e9) {
                dis[i] = -1;
            }
        }
        return dis;
    }
}
