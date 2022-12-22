package com.atul.graph;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{3,12},{-2,5},{-4,1}};//{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }

    static class Pair{
        int[] cor;
        int wt;

        public Pair(int[] cor, int wt) {
            this.cor = cor;
            this.wt = wt;
        }
    }
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<int[], List<Pair>> adj = new HashMap<>();
        HashMap<int[], Boolean> vis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] x_point = points[i];
            vis.put(x_point, false);
            for (int j = 0; j < n; j++) {
                int[] y_point = points[j];
                if(i!=j){
                    adj.putIfAbsent(x_point, new ArrayList<>());
                    List<Pair> pt = adj.get(x_point);
                    int dist = Math.abs(x_point[0]-y_point[0])+Math.abs(x_point[1]-Math.abs(y_point[1]));
                    pt.add(new Pair(y_point, dist));
                    adj.put(x_point,pt);
                }
            }
        }
        int sum = 0;
        Queue<Pair> pq = new PriorityQueue<>((a, b)->a.wt-b.wt);
        pq.add(new Pair(points[0],0));
        while (!pq.isEmpty()){
            Pair node = pq.poll();
            int[] secCor = node.cor;
            int wt = node.wt;
            if(vis.containsKey(secCor) && vis.get(secCor)) continue;
            vis.put(secCor, true);
            sum+=wt;
            for(Pair it : adj.get(secCor)){
                int[] cdr = it.cor;
                int dist = it.wt;
                if(vis.containsKey(cdr) && !vis.get(cdr)){
                    pq.offer(new Pair(cdr, dist));
                }
            }
        }
        return sum;
    }
}
