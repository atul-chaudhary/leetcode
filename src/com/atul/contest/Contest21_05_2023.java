package com.atul.contest;

import java.util.*;

public class Contest21_05_2023 {
    public static void main(String[] args) {

        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        return solve(nums1, nums2, k, 0, 0, nums2[0]);
    }

    private static long solve(int[] nums1, int[] nums2, int k, int index, long sum, long min) {
        if (index >= nums1.length || k < 0) {
            return sum * min;
        }

        long pick = solve(nums1, nums2, k - 1, index + 1, sum + nums1[index], Math.min(min, nums2[index]));
        long notPick = solve(nums1, nums2, k, index + 1, sum, min);

        return Math.max(pick, notPick);
    }

    static class Pair {
        int val;
        int fre;

        public Pair(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int[] result = new int[k];
        int index = 0;
        while (k > 0) {
            result[index++] = pq.poll().val;
            k--;
        }
        return result;
    }


    public static String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (s.charAt(right) < s.charAt(left)) {
                    sb.replace(left, left + 1, String.valueOf(s.charAt(right)));
                } else {
                    sb.replace(right, right + 1, String.valueOf(s.charAt(left)));
                }
            }
            left++;
            right--;
        }
        return sb.toString();
    }

    public static int minLength(String s) {
        String[] arr = s.split("AB|CD");
        if (arr.length == 1 && arr[0].equals(s)) {
            return s.length();
        }

        int size = arr.length;
        String create = "";
        for (int i = 0; i < size; i++) {
            create += arr[i];
        }
        return minLength(create);
    }
}
