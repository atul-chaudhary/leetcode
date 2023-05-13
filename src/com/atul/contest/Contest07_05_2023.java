package com.atul.contest;


import java.util.*;

public class Contest07_05_2023 {
    public static void main(String[] args) {
        int[][] nums = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(mostPoints(nums));
    }

        public static long mostPoints(int[][] nums) {
            int n = nums.length;
            Long[] dp = new Long[n + 1];
            return solve(nums, 0, dp);
        }

        private static long solve(int[][] nums, int index, Long[] dp) {
            if (index >= nums.length) {
                return 0;
            }

            if (dp[index] != null) return dp[index];

            long pick = nums[index][0] + solve(nums, index + nums[index][1] + 1, dp);
            long notPick = solve(nums, index + 1, dp);

            return dp[index] = Math.max(pick, notPick);
        }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Integer[][] dp = new Integer[n][m];
        return solve(nums1, nums2, 0, 0, dp);
    }

    private static int solve(int[] nums1, int[] nums2, int i, int j, Integer[][] dp) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + solve(nums1, nums2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(nums1, nums2, i, j + 1, dp), solve(nums1, nums2, i + 1, j, dp));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int first_row = 0;
        int last_row = n - 1;
        int first_col = 0;
        int last_col = n - 1;
        int num = 1;
        while (first_col <= last_col && first_row <= last_row) {

            for (int i = first_col; i <= last_col; i++) {
                result[first_row][i] = num++;
            }
            first_row++;

            for (int i = first_row; i <= last_row; i++) {
                result[i][last_col] = num++;
            }
            last_col--;

            if (first_col < last_col) {
                for (int i = last_col; i >= first_col; i--) {
                    result[last_row][i] = num++;
                }
                last_row--;
            }
            if (first_row < last_row) {
                for (int i = last_row; i >= first_row; i--) {
                    result[i][first_col] = num++;
                }
                first_col++;
            }
        }
        return result;
    }


    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];
        int[] pref = new int[n];

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                count++;
                set.add(nums[i]);
            }
            pref[i] = count;
        }
        set.clear();
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(nums[i])) {
                count++;
                set.add(nums[i]);
            }
            suff[i] = count;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                result[i] = pref[i];
            } else {
                result[i] = pref[i] - suff[i + 1];
            }
        }
        return result;
    }
}

class FrequencyTracker {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> fre = new HashMap<>();

    public FrequencyTracker() {

    }

    public void add(int number) {
        int cur = map.getOrDefault(number, 0);
        map.put(number, cur + 1);
        if (cur > 0) {
            fre.put(cur, fre.getOrDefault(cur, 0) - 1);
            if (fre.get(cur) == 0) {
                fre.remove(cur);
            }
        }
        fre.put(map.get(number), fre.getOrDefault(map.get(number), 0) + 1);
    }

    public void deleteOne(int number) {
        if (map.containsKey(number)) {
            int cur = map.get(number);
            map.put(number, cur - 1);
            if (map.get(number) == 0) {
                map.remove(number);
            }
            fre.put(cur, fre.get(cur) - 1);
            if (fre.get(cur) == 0) {
                fre.remove(cur);
            }
            if (map.containsKey(number))
                fre.put(map.get(number), fre.get(number) + 1);
        }
    }

    public boolean hasFrequency(int frequency) {
        //System.out.println(map);
        //System.out.println(fre);
        return fre.get(frequency) != null;
    }
}

