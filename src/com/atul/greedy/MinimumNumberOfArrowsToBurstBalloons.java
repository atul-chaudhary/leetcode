package com.atul.greedy;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}};
        System.out.println(findMinArrowShots(arr));
    }

    public static int findMinArrowShots(int[][] nums) {
        Arrays.sort(nums, (a, b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        for (int[] row : nums) System.out.println(Arrays.toString(row));
        int n = nums.length;
        int count = 0;
        return count;
    }
}
