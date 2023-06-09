package com.atul.contest;

import java.util.*;




public class Contest04_06_2023 {
    public static void main(String[] args) {

    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        boolean f = true;
        for (int i = 2; i < n; i++) {
            int cur_d = arr[i] - arr[i - 1];
            if (cur_d != d) {
                f = false;
            }
        }

        if (f) return true;
        return false;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        double slope = ((coordinates[1][0] - coordinates[0][0]) * 1.0) / (coordinates[1][1] - coordinates[0][1]);
        for (int i = 2; i < n; i++) {
            double slope_temp = ((coordinates[i][0] - coordinates[i - 1][0]) * 1.0) / (coordinates[i][1] - coordinates[i - 1][1]);
            if (slope_temp != slope) {
                return false;
            }
        }
        return true;
    }


    public int minimizedStringLength(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    }

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int oneIndex = -1;
        int nIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneIndex = i;
            }

            if (nums[i] == n) {
                nIndex = i;
            }
        }

        if (oneIndex > nIndex) {
            return (n - nIndex - 1) + (oneIndex) - 1;
        }

        return (n - nIndex - 1) + oneIndex;
    }

}
