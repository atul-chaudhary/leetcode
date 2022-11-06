package com.atul.contest;

import java.net.Inet4Address;
import java.util.*;

public class MaximumSumDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] arr = {9,9,9,1,2,3};
        int k = 3;
        System.out.println(maximumSubarraySum(arr, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        //Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        long max = Long.MIN_VALUE;
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//                Set<Integer> index = map.get(nums[i]);
//                index.add(i);
//                map.put(nums[i], index);
//            }else{
//                Set<Integer> index = new HashSet<>();
//                index.add(i);
//                map.put(nums[i], index);
//            }
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            sum += nums[i];
            count++;
            if (count == k) {
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }
                sum -= nums[i - (k - 1)];
//                if(map.get(nums[i-(k-1)]).size() == 1){
//                    map.remove(nums[i-(k-1)]);
//                }else{
//                    Set<Integer> index = map.get(nums[i-(k-1)]);
//                    index.remove(i - (k - 1));
//                    map.put(nums[i - (k - 1)], index);
//                }
                if(map.get(nums[i-(k-1)]) == 1){
                    map.remove(nums[i-(k-1)]);
                }else{
                    map.put(nums[i - (k - 1)], map.get(nums[i - (k - 1)])-1);
                }
                count--;
            }
        }
        return max == Long.MIN_VALUE ? 0 : max;
    }
}
