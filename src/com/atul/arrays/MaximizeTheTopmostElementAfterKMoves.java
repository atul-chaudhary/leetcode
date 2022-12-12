package com.atul.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeTheTopmostElementAfterKMoves {
    public static void main(String[] args) {
        int[] nums = {68,76,53,73,85,87,58,24,48,59,38,80,38,65,90,38,45,22,3,28,11};//{91,98,17,79,15,55,47,86,4,5,17,79,68,60,60,31,72,85,25,77,8,78,40,96,76,69,95,2,42,87,48,72,45,25,40,60,21,91,32,79,2,87,80,97,82,94,69,43,18,19,21,36,44,81,99};//{35,43,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49};
        System.out.println(maximumTop(nums, 1));
    }

    public static int maximumTop(int[] nums, int k) {
        if (k == 1 &&  nums.length == 1) return -1;
        if(k>=nums.length) return Arrays.stream(nums).max().getAsInt();
        int index = 0;
        int remove = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (remove < k-1) {
            pq.offer(nums[index++]);
            remove++;
        }
        int num = nums[index++];
        int peek = nums[index];
        //return pq.peek();
        return Math.max(pq.size() >= 1 ? pq.peek():0, peek);
    }
}
