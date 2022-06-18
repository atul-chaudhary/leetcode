package com.atul.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1}, {-2,4}};
        //System.out.println(Arrays.toString(kClosest(points, 1)));
        int[][] result = kClosest(points, 2);
        for(int[] i : result){
            System.out.println(Arrays.toString(i));
        }
    }
    static class Pair{
        int[] point;
        Integer distance;
        public Pair(int[] point, Integer distance){
            this.point = point;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "point=" + Arrays.toString(point) +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        Queue<Pair> pq = new PriorityQueue<>((a, b)->b.distance.compareTo(a.distance));
        for(int i=0;i<points.length;i++){
            pq.offer(new Pair(points[i], distance(points[i][0], points[i][1])));
            if(pq.size() > k){
                pq.poll();
            }
        }

        int i=0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll().point;
        }
        return result;
    }
    private static int distance(int a, int b){
        return (int)Math.pow((Math.pow(a,2)+Math.pow(b,2)),0.5);
    }
}
