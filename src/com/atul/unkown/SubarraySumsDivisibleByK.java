package com.atul.unkown;

import java.util.*;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
        System.out.println(subarraysDivByKOpt(nums, k));
    }


    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for(int it : nums){
            sum+=it;
        }
        long rem = (sum % p);
        if(rem == 0) return  0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = n;
        sum=0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            long curRem =  (sum %p);

            long searchForRem = rem - curRem;
            if(searchForRem < 0) searchForRem+=p;
            if(map.containsKey((int)searchForRem)){
                len = Math.min(len, i-map.get((int)searchForRem));
            }
            map.put((int)curRem, i);
        }
        return (len == n) ? -1 : len;
    }

    public static int subarraysDivByKOpt(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum  = 0;
        int count = 0;
        for (int it : nums) {
           sum+=it;
           int rem = sum % k;
           if(rem < 0) rem+=k;
           if(map.containsKey(rem)){
               count+=map.get(rem);
           }
           map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return count;
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = i; j < n; j++) {
                curSum += nums[j];
                if (curSum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
