package com.atul.arrays;

import java.util.Arrays;

public class MinimumAverageDifference {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 9, 5, 3};
        System.out.println(minimumAverageDifference(arr));
    }

    public static int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] sums = new long[n];
        long sum = 0;
        int j = 0;
        for (int it : nums) {
            sum += it;
            sums[j++] = sum;
        }
        System.out.println(Arrays.toString(sums));
        long min = Long.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            long first = sums[i] / (i + 1);
            long second = i != n - 1 ? ((sums[n - 1] - sums[i]) / (n - (i + 1))) : 0;
            long cal = Math.abs(first - second);
            if (cal < min) {
                min = cal;
                ans = i;
            }
        }
        return ans;
    }
}
