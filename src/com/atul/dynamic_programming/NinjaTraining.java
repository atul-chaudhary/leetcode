package com.atul.dynamic_programming;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };

        System.out.println(solve(arr.length-1, 0, arr));
    }

    private static int solve(int day, int index, int[][] arr) {
        if (day == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (i != index) {
                    max = Math.max(max, arr[day][i]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = arr[day][i] + solve(day - 1, i, arr);
        }

        return ans;
    }
}
