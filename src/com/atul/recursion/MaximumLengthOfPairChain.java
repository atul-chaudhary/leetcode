package com.atul.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int[][] nums = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        System.out.println(findLongestChain(nums));
    }

    public static int findLongestChain(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Map<String, Integer> dp = new HashMap<>();
        return solve(nums, 0, -1, dp);
    }

    private static int solve(int[][] nums, int index, int prev, Map<String, Integer> dp) {
        if (index >= nums.length) {
            return 0;
        }
        if(dp.containsKey(index+"|"+prev)) return dp.get(index+"|"+prev);
        int pick = 0;
        if (prev == -1 || nums[prev][1] < nums[index][0]) {
            pick = 1 + solve(nums, index + 1, index, dp);
        }
        int notPick = solve(nums, index + 1, prev, dp);
        int num = Math.max(notPick, pick);
        dp.put(index+"|"+prev, num);
        return num;
    }

    private static int solve(int[][] nums, int index, int[] prev, Map<String, Integer> dp) {
        if (index >= nums.length) {
            return 0;
        }
        String str = prev != null ? Arrays.toString(prev) + "|" + index : "";
        if (dp.containsKey(str)) return dp.get(str);
        int pick = 0;
        if (prev == null || prev[1] < nums[index][0]) {
            pick = 1 + solve(nums, index + 1, nums[index], dp);
        }
        int notPick = solve(nums, index + 1, prev, dp);
        int num = Math.max(pick, notPick);
        dp.put(str, num);
        return num;
    }
}
