package com.atul.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4,18,8};
        System.out.println(largestPerimeter(arr));
    }

    public static int largestPerimeter(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }

        int first = pq.poll();
        int second = pq.poll();
        int third = pq.poll();
        while(true){
            if(check(pq, first, second, third) == true){
                return first+second+third;
            }else{
                if(!pq.isEmpty()){
                    first = pq.poll();
                }else{
                    return 0;
                }
            }
        }
        //return 0;
    }

    private static boolean check(PriorityQueue<Integer> pq, int first, int second, int third){
        double s = (first+second+third)*1.0/2;
        if(s - Math.max(first, Math.max(second, third)) <= 0){
            return false;
        }
        return true;
    }
}
