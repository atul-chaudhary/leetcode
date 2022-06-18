package com.atul.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        long[] arr = {4,3,2,6};
        System.out.println(minCost(arr, 4));
    }

   public static long minCost(long arr[], int n)
    {
        // your code here
        Queue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
        }
        System.out.println(pq);
        long count = 0;
        while(pq.size() >=2){
            long a = pq.poll();
            long b = pq.poll();
            long re =a+b;
            System.out.println(re);
            pq.offer(re);
            count+=re;
        }
        return count;
    }
}
