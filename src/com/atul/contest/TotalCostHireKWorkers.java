package com.atul.contest;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostHireKWorkers {

    static class Pair{
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,1};
        int k = 3;
        int cand = 4;
        System.out.println(totalCost(arr, k, cand));
    }

    public static long totalCost(int[] nums, int k, int candidates) {
        Queue<Pair> rightpq = new PriorityQueue<>((a, b)->a.val==b.val ? a.index-b.index : a.val-b.val);
        Queue<Pair> leftpq = new PriorityQueue<>((a, b)->a.val==b.val ? a.index-b.index : a.val-b.val);
        int i=0;
        for (i = 0; i < candidates; i++) {
            leftpq.add(new Pair(nums[i], i));
        }
        int n = nums.length;
        int rem = n-i;
        rem = Math.min(candidates, rem);
        int j = 0;
        for(j=n-1;j>=n-rem;j--){
            rightpq.add(new Pair(nums[j], j));
        }
        int cost = 0;
        while(k >0 && !leftpq.isEmpty() && !rightpq.isEmpty()){
            Pair left = leftpq.poll();
            Pair right = rightpq.poll();
            if(left.val <= right.val){
                cost+=left.val;
                rightpq.add(right);
                if(i <= j){
                    leftpq.add(new Pair(nums[i], i));
                    i++;
                }
            }else {
                cost+=right.val;
                leftpq.add(left);
                if(i <= j){
                    rightpq.add(new Pair(nums[j], j));
                    j--;
                }
            }
            k--;
        }
        if(k>0){
            Queue<Pair> pq = leftpq;
            if(pq.isEmpty()){
                pq = rightpq;
            }
            while(k>0){
                cost+=pq.poll().val;
                k--;
            }
        }
        return cost;
    }
}
