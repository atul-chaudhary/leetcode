package com.atul.dfs;

public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minimizeTheDifference(arr, 13));
    }

    public static int minimizeTheDifference(int[][] mat, int target) {
        for (int i = 0; i < mat[0].length; i++) {

        }
        return solve(mat, target, 0);
    }

    private static int solve(int[][] mat, int target, int row) {
        //System.out.println("row and col "+row+ " "+col);
        if (row == mat.length - 1) {
            //return mat[row][col];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < mat[0].length; i++) {
            int temp = mat[row][i] + solve(mat, target, row + 1);
        }
        return ans;
    }
}
