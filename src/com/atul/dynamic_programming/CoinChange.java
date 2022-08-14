package com.atul.dynamic_programming;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int target = 11;
        System.out.println(solve(arr, arr.length-1, target));
    }

    private static int solve(int[] arr, int n, int target) {
        if (target == 0) {
            return 1;
        }

        if (n < 0) return 0;

        if (arr[n] <= target) {
            return Math.min(
                    solve(arr, n, target - arr[n]),
                    solve(arr, n - 1, target)
            );
        } else {
            return solve(arr, n, target);
        }
    }
}
