package com.atul.contest;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class contest11_12_2022 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 16, 8, 2};
        System.out.println(longestSquareStreak(arr));
    }


    public static int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : nums) {
            map.put(it, 1);
        }
        int max = 0;
        for (int it : nums) {
            int num = it;
            int len = 0;
            while (map.containsKey(num)) {
                len++;
                num = num * num;
            }
            max = Math.max(max, len);
        }
        if (max < 2) return -1;
        return max;
    }

    public static int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int n = grid.length;
        int m = grid[0].length;
        int curr = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp = Math.max(temp, grid[j][curr]);
            }
            curr++;
            sum += temp;
        }
        return sum;
    }
}
