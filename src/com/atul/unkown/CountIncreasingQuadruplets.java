package com.atul.unkown;

public class CountIncreasingQuadruplets {

    public static void main(String[] args) {

    }


    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] countSmaller = new int[n][n];
        int[][] countLarger = new int[n][n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    countLarger[i][j] = ++count;
                } else {
                    countLarger[i][j] = count;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    countSmaller[i][j] = ++count;
                } else {
                    countSmaller[i][j] = count;
                }
            }
        }

        long result = 0;
        for (int j = 0; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[k] > nums[j]) continue;
                result += (countSmaller[0][k] - countSmaller[j][k]) * 1.0 * (countLarger[j][n - 1] - countLarger[k][n - 1]);
            }
        }
        return result;
    }

}
