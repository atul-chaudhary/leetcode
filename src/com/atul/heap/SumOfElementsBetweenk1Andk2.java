package com.atul.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SumOfElementsBetweenk1Andk2 {

    public static void main(String[] args) {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        System.out.println(sumBetweenTwoKth(arr, 3, 6));
    }

    public static int sumBetweenTwoKth(int [] arr, int k1, int k2){
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size() > k2){
                pq.poll();
            }
        }
        pq.poll();
        int re = k2-k1-1;
        int count  =0;
        while(re-- > 0){
            int a = pq.poll();
            count+=a;
        }
        return count;
    }
}
