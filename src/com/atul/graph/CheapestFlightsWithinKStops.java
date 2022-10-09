package com.atul.graph;

import java.util.ArrayList;
import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 3;
        int[][] flig = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k=1;
        System.out.println(findCheapestPrice(n, flig, src, dst,k));
    }
    /*
    10
    [[3,4,4],
    [2,5,6],
    [4,7,10],
    [9,6,5],
    [7,4,4],
    [6,2,10],
    [6,8,6],
    [7,9,4],
    [1,5,4],
    [1,0,4],
    [9,7,3],
    [7,0,5],
    [6,5,8],
    [1,7,6],[4,0,9],[5,9,1],[8,7,3],[1,2,6],[4,1,5],[5,2,4],[1,9,1],[7,8,10],[0,4,2],[7,2,8]]
6
0
7
     */

    static class Pair{
        int node;
        int price;
        Pair(int node, int price){
            this.node = node;
            this.price = price;
        }
    }
    static class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third){
            this.first  = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int findCheapestPrice(int n, int[][] arr, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = arr.length;
        for(int i=0;i<m;i++){
            int u= arr[i][0];
            int v = arr[i][1];
            int price = arr[i][2];
            adj.get(u).add(new Pair(v, price));
        }

        Queue<Tuple> pq = new PriorityQueue<>((a, b)-> a.second - b.second);//LinkedList<>();
        pq.add(new Tuple(src, 0, 0));

        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int) 1e9;
        }

        while(!pq.isEmpty()){
            Tuple p = pq.poll();
            int node = p.first; // node
            int price = p.second; //price
            int stops = p.third; // stops
            //if(stops == k && node == dst) return price;
            for(Pair temp : adj.get(node)){
                if(stops <= k && price + temp.node < dist[temp.node]){
                    dist[temp.node] =  price + temp.price;
                    pq.offer(new Tuple(temp.node, price + temp.price, stops + 1));
                }
            }
        }
        return dist[dst];
    }
}
