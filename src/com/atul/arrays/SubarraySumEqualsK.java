package com.atul.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        subarraySumHashMap(arr, 3);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                //System.out.println(i+ " "+ j+ " "+sum);
                if(sum == k){
                    count++;
                }
            }
        }
        //System.out.println(count);
        return count;
    }

    public static int subarraySumHashMap(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hashMap.containsKey(sum-k)){
                count++;
            }
            hashMap.put(sum, hashMap.getOrDefault(sum,0));
        }
        System.out.println(count);
        return count;
    }
}
