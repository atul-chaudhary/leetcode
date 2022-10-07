package com.atul.graph;

import java.util.*;

public class DijkatrasAlog {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] arr = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        System.out.println(shortestPath(n, m, arr));

        StringBuilder sb = new StringBuilder(String.valueOf(123));

        String s = String.valueOf(123);
    }

    static class Pair{
        int distance;
        int node;
        Pair(int first, int second){
            this.distance = first;
            this.node = second;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        Queue<Pair> pq = new PriorityQueue<>((a, b)-> a.distance -b.distance);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];

        Arrays.fill(dist, (int) 1e9);
        dist[1] = 0;
        pq.offer(new Pair(0,1));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int node = pair.node; //node
            for(Pair it : adj.get(node)){
                if(dist[node] + it.distance < dist[it.node]){
                    dist[it.node] = dist[node] + it.distance;
                    parent[it.node] = node;
                    pq.offer(new Pair(dist[it.node], it.node));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        int num = n;
        List<Integer> result = new ArrayList<>();
        while(num != 1){
            result.add(num);
            num = parent[num];
        }
        result.add(1);
        Collections.reverse(result);
        return  result;
    }
}
