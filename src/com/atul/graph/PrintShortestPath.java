package com.atul.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrintShortestPath {

    static class Pair {
        int ver;
        int des;

        public Pair(int ver, int des) {
            this.ver = ver;
            this.des = des;
        }
    }

    public static void main(String[] args) {

    }


    private static String solve(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int[] path = new int[n+1];
        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            path[i] = -1;
            dist[i] = (int) 1e9;
        }
        dist[0] = 0;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.des - b.des);
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.ver;

            for(Pair it : adj.get(node)){
                int d = it.des;
                int v = it.ver;
                if(dist[node]+d < dist[v]){
                    dist[v] = dist[node]+d;
                    path[v] = node;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        int src = n;
        StringBuilder sb = new StringBuilder();
        while(src != 0){
            sb.append(path[src]);
            src = path[src];
        }
        return sb.toString();
    }

}
