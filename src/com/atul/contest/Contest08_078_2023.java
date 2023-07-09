package com.atul.contest;

import java.util.*;

public class Contest08_078_2023 {
    public static void main(String[] args) {
        int[][] nums = {{0, 0}, {1, 1}, {0, 2}};
        System.out.println(Arrays.toString(countBlackBlocks(3, 3, nums)));
    }

    public static long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] result = new long[5];
        int[][] mat = new int[m][n];
        int len = coordinates.length;
        for (int i = 0; i < len; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            mat[x][y] = 1;
        }
        int newM = m - 2;
        int newN = n - 2;
        for (int i = 0; i <= newM; i++) {
            for (int j = 0; j <= newN; j++) {
                int first = mat[i][j];
                int second = mat[i + 1][j];
                int third = mat[i][j + 1];
                int fourth = mat[i + 1][j + 1];
                result[first + second + third + fourth]++;
            }
        }
        return result;
    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int len = moveFrom.length;
        for (int i = 0; i < len; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            int val = map.remove(from);
            map.put(to, val);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            set.add(key);
        }

        return new ArrayList<>(set);
    }
}
