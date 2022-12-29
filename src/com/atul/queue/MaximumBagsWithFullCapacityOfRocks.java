package com.atul.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumBagsWithFullCapacityOfRocks {
    public static void main(String[] args) {
        int[] cap = {10, 2, 2};
        int[] rocks = {2, 2, 0};
        int add = 100;
        System.out.println(maximumBagsOpt(cap, rocks, add));
    }

    public static int maximumBagsOpt(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                count++;
            }else if (additionalRocks >= nums[i]){
                count++;
                additionalRocks-=nums[i];
            }else break;
        }
        return count;
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        Queue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = capacity[i] - rocks[i];
            if (num == 0) count++;
            else
                pq.offer(num);
        }
        while (additionalRocks > 0 && !pq.isEmpty()) {
            int num = pq.poll();
            if (additionalRocks >= num) {
                count++;
                additionalRocks -= num;
            } else break;
        }
        return count;
    }
}
