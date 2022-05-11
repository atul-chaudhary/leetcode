package com.atul.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Stack<Integer> stack = map.get(nums[i]);
                stack.add(i);
                map.put(nums[i], stack);
            }
            Stack<Integer> stack = new Stack<>();
            stack.add(i);
            map.put(nums[i], map.getOrDefault(nums[i], stack));
        }
        for(Integer i : map.keySet()){
            if (map.containsKey(target - i)){
                result[0] =map.get(i).peek();
                map.get(i).pop();
                result[1] = map.get(target-i).peek();
                map.get(target-i).pop();
                return result;
            }
        }
        return new int[]{};
    }
}
