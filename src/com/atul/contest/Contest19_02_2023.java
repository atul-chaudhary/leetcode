package com.atul.contest;

import java.util.TreeMap;

public class Contest19_02_2023 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(nums, 5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int it : weights) {
            sum += it;
        }
        System.out.println(sum+" sum");
        int left = 0;
        int right = sum;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (solve(mid, weights, days)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            System.out.println(left + "<<>>" + right + "<<>>" + mid);
        }
        return left;
    }

    private static boolean solve(int mid, int[] weights, int days) {
        int index = 0;
        int curDay = 0;
        int n = weights.length;

        for (index = 0; index < n; index++) {
            int curMid = mid;
            boolean flag = false;
            while (index < n && weights[index] <= curMid) {
                curMid -= weights[index++];
                flag = true;
            }
            if(flag) index--;
            curDay++;
            if (curDay >= days) return false;
            if (index < n && weights[index] > mid) return false;
        }
        if (curDay >= days) {
            return false;
        }
        System.out.println(mid+" mid "+curDay);
        return true;
    }

    public int minOperations(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int power = (int) (Math.log(i) / Math.log(2));
            int cur = (int) Math.pow(2, power);
            dp[i] = 1 + dp[i - cur];

            cur = (int) Math.pow(2, 1 + power);
            dp[i] = Math.min(dp[i], 1 + dp[cur - i]);
        }
        return dp[n];
    }

    class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
            for (int[] it : nums1) {
                treeMap.put(it[0], treeMap.getOrDefault(it[0], 0) + it[1]);
            }
            for (int[] it : nums2) {
                treeMap.put(it[0], treeMap.getOrDefault(it[0], 0) + it[1]);
            }
            int[][] result = new int[treeMap.size()][2];
            int index = 0;
            for (Integer it : treeMap.keySet()) {
                result[index++] = new int[]{it, treeMap.get(it)};
            }
            return result;
        }
    }

    public static int squareFreeSubsets(int[] nums) {
        return solve(nums, 0, 1, 0);
    }

    private static int solve(int[] nums, int index, long number, int count) {
        if (index >= nums.length) {
            if (isSquareFree(number) && count >= 1) {
                return 1;
            }
            return 0;
        }

        int pick = solve(nums, index + 1, number * nums[index], count + 1);
        int notPick = solve(nums, index + 1, number, count);
        return pick + notPick;
    }

    static boolean isSquareFree(long n) {
        if (n % 2 == 0)
            n = n / 2;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (n % i == 0) {
                n = n / i;

                if (n % i == 0)
                    return false;
            }
        }

        return true;
    }
}
