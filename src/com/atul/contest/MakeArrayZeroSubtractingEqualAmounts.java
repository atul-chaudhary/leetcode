package com.atul.contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MakeArrayZeroSubtractingEqualAmounts {
    public static void main(String[] args) {
        int[] nums = {70,0,35,65,98,30,85,19,77,92,86,13,27,52,91,74,53,69,40,38,51,88,64,66,58,9,42,7,8,25,15,99,82,85,24,9,37,0,73,85,22,97,8,9,40,63,47,52,15,92,14,85,38,34,19,52,3,50,3,39,23,81,62,100,56,73,81,72,87,67,16,87,59,14,73,79,26,42,34,35,45,61,17,31,12,36,80,94,97,93,29,27,87,66,64,60,74,84,65,99};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.clear();
        for(int it : nums){
            if(it == 0) continue;
            pq.offer(it);
        }

        int count =0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            System.out.println(num);
            count++;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0) continue;
                nums[i]= nums[i]-num;
                System.out.println(Arrays.toString(nums));
            }
            if(check(nums)) return count;
            pq = fillPq(nums);
        }
        return count;
    }

    private static PriorityQueue<Integer> fillPq(int [] nums){
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        for(int it : nums){
            if(it == 0) continue;
            temp.offer(it);
        }
        return temp;
    }

    private  static boolean check(int[] nums){
        boolean flag = true;
        for(int it : nums){
            if(it !=0){
                flag = false;
            }
        }
        return flag;
    }
}
