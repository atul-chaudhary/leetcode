package com.atul.contest;

import java.util.PriorityQueue;

public class MinimumDeletionsToMakeArrayDivisible {
    public static void main(String[] args) {
        int[] nums = {};
        int [] numsDivide = {};
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int it: nums){
            pq.offer(it);
        }

        int min = Integer.MAX_VALUE;
        for(int it: numsDivide){
            min = Math.min(min, it);
        }
        int count = 0;
        boolean global = false;
        while(!pq.isEmpty()){
            int ele = pq.poll();
            boolean isAllDivided = false;
            if(min % ele ==0){
                boolean isDiv = true;
                for(int i=0;i<numsDivide.length;i++){
                    if(numsDivide[i] % ele != 0){
                        isAllDivided = false;
                    }
                }
            }
            count++;
            if(isAllDivided) return count;
        }
        return -1;
    }
}
