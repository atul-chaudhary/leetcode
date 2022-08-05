package com.atul.recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        //System.out.println(solve(0, new int[]{10, 20, 30, 10}, 0));
    }

    private static int solve(int i, int n) {
        if (i == n) {
            return 1;
        }
        if (i > n) return 0;
        return solve(i + 1, n) + solve(i + 2, n);
    }
}
