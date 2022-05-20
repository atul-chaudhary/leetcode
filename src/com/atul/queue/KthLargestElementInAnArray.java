package com.atul.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargestNew(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i< nums.length;i++){
            queue.add(nums[i]);
            //queue.offer()
        }
        int result = -1;
        for(int i=0;i<k;i++){
            result = queue.remove();
        }
        return result;
    }

    public static int findKthLargestNew(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);
            System.out.println(pq);
            if(pq.size() > k) {
                pq.poll();
                System.out.println(pq);
                System.out.println();
            }
        }
        //System.out.println(pq);
        return pq.peek();
    }
}
