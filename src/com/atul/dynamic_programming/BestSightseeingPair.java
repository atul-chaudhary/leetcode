package com.atul.dynamic_programming;

public class BestSightseeingPair {
    public static void main(String[] args) {
        int[] arr = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(arr));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int curMax = values[0];
        int n = values.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, curMax + values[i]-i);
            curMax = Math.max(curMax, values[i]+i);
        }
        return max;
    }
}
