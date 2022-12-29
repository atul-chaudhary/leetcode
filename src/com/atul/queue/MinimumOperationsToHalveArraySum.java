package com.atul.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumOperationsToHalveArraySum {
    public static void main(String[] args) {
        int[] nums = {5,19,8,1};//{3,8,20};
        System.out.println(halveArray(nums));
    }

    public static int halveArray(int[] nums) {
        long total = 0;
        Queue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : nums){
            total+=it;
            pq.offer((double)it);
        }
        double half = total*1.0/2;
        double cur = total;
        long count = 0;
        while(cur > half && !pq.isEmpty()){
            double num = pq.poll()*1.0/2;
            cur-=num;
            pq.offer(num);
            count++;
        }
        return (int)count;
    }
}
