package com.atul.recursion;

import java.util.*;

public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        int[][] edges = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(edges));
    }

    //this question is easy
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b)->a[0]-b[0]);
        for(int[] row : points) System.out.println(Arrays.toString(row));
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(points[i][0] > points[i-1][1]){
                count++;
            }
        }
        return count;
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        String[] result = new String[n];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int index = entry.getValue();
            if (count == 0) {
                result[index] = "Gold Medal";
            } else if (count == 1) {
                result[index] = "Silver Medal";
            } else if (count == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(count + 1);
            }
            count++;
        }
        return result;
    }

    public static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int t = sum - x;
        int left = 0;
        int right = 0;
        sum = 0;
        int ans = -1;
        while (right < n) {
            sum += nums[right];
            if (sum > t) {
                while (sum > t && left <= right) {
                    sum -= nums[left];
                    left++;
                }
            }
            if (sum == t) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans == -1 ? ans : n - ans;
    }

    private static int solve(int[] nums, int target, int left, int right) {
        if (target == 0) return 0;
        if (target < 0 || left > right) return (int) 1e6;

        int leftPick = 1 + solve(nums, target - nums[left], left + 1, right);
        int rightPick = 1 + solve(nums, target - nums[right], left, right - 1);

        return Math.min(leftPick, rightPick);
    }
}
