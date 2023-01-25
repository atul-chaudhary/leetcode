package com.atul.greedy;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        int[] nums = {95,11,8,65,5,86,30,27,30,73,15,91,30,7,37,26,55,76,60,43,36,85,47,96,6};
        System.out.println(minimumCardPickup(nums));
    }

    public static int minimumCardPickup(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            count++;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i])>=2){
                min = Math.min(min, count);
                while (nums[left] != nums[i] && left < i){
                    map.put(nums[left], map.get(nums[left])-1);
                    if(map.get(nums[left])==0) map.remove(nums[left]);
                    left++;
                    count--;
                    min = Math.min(min, count);
                }
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]);
                count--;
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int minOperations(int n) {
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = 2 * i + 1;
            sum += nums[i];
        }

        int target = sum / n;
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += Math.abs(nums[i] - target);
        }
        return num / 2;
    }
}
