package com.atul.contest;


import java.util.*;

public class Contest21_01_2023 {
    public static void main(String[] args) {
       int[] nums1 = {4,2,3,1,1};
       int[] nums2 = {7,5,10,9,6};
       int k = 1;
        System.out.println(maxScoreOpt(nums1, nums2, k));
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static long maxScoreOpt(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] nums = new Pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(nums, (a, b) -> b.j - a.j);
        Queue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            Pair pair = nums[i];
            pq.offer(pair.i);
            sum += pair.i;
        }

        long result = sum * nums[k-1].j;
        for (int i = k; i < n; i++) {
            if(pq.size() == k) sum-=pq.poll();
            pq.offer(nums[i].i);
            sum+=nums[i].i;
            result = Math.max(result, sum*nums[i].j);
        }
        return result;
    }

    public static long minOperationsopt(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long negCount = 0;
        long postCount = 0;
        long sameCount = 0;
        for (int i = 0; i < n; i++) {
            int num = nums2[i] - nums1[i];
            if (num == 0) {
                sameCount++;
                continue;
            }
            if (k == 0 && num != 0) return -1;
            if (num % k != 0) return -1;
            if (num < 0) {
                negCount += num;
            } else if (num > 0) {
                postCount += num;
            }
        }
        System.out.println(sameCount);
        if (sameCount == n) return 0;
        if (Math.abs(negCount) != postCount) return -1;
        return postCount / k;
    }


    public static long minOperations(int[] nums1, int[] nums2, int k) {
        Queue<Integer> ps = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> neg = new PriorityQueue<>();
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (nums2[i] - nums1[i] < 0) {
                neg.offer(nums2[i] - nums1[i]);
            }
            if (nums2[i] - nums1[i] > 0) {
                ps.offer(nums2[i] - nums1[i]);
            }
        }
        long count = 0;
        while (!ps.isEmpty() || !neg.isEmpty()) {
            if (ps.isEmpty() && !neg.isEmpty()) {
                return -1;
            }
            if (!ps.isEmpty() && neg.isEmpty()) {
                return -1;
            }
            int negative = neg.poll() + k;
            if (negative > 0)
                return -1;
            if (negative < 0)
                neg.offer(negative);
            int positive = ps.poll() - k;
            if (positive < 0)
                return -1;
            if (positive > 0)
                ps.offer(positive);
            count++;
        }
        return count;
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        return solve(nums1, nums2, 0, 0, Integer.MAX_VALUE, k, 0);
    }

    private static long solve(int[] nums1, int[] nums2, int index, long sum, long min, int k, int count) {
        if (count == k) {
            return sum * min;
        }
        if (index >= nums1.length) {
            return 0;
        }

        long pick = solve(nums1, nums2, index + 1, sum + nums1[index], Math.min(min, nums2[index]), k, count + 1);
        long notPick = solve(nums1, nums2, index + 1, sum, min, k, count);
        return Math.max(pick, notPick);
    }


    public static int getCommon(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int it : nums2) {
            if (map1.containsKey(it)) return it;
        }
        return -1;
    }
}
