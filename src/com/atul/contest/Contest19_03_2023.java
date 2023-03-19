package com.atul.contest;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;


public class Contest19_03_2023 {
    public static void main(String[] args) {
        int[][] grid = {{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}};//{{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}};
        System.out.println(checkValidGrid(grid));
    }

    public static boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0) return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == n * n - 1) continue;
                boolean yo = check(grid, i, j, grid[i][j]);
                System.out.println(yo + "<<>>" + grid[i][j]);
//                if (check(grid, i, j, grid[i][j]) == false) {
//                    return false;
//                }
            }
        }
        return true;
    }

    private static boolean check(int[][] grid, int i, int j, int num) {
        int n = grid.length;
        int[][] cor = {{-1, -2}, {1, -2}, {-1, +2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        int k = cor.length;
        for (int l = 0; l < k; l++) {
            int xtemp = cor[l][0] + i;
            int ytemp = cor[l][1] + j;
            if (xtemp >= 0 && xtemp < n && ytemp >= 0 && ytemp < n) {
                if (grid[xtemp][ytemp] == num + 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int beautifulSubsets(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        return solve(nums, k, 0, list) - 1;
    }

    private static int solve(int[] nums, int k, int index, List<Integer> list) {
        if (index >= nums.length) {
            if (check(list, k)) {
                return 1;
            }
            return 0;
        }

        list.add(nums[index]);
        int pick = solve(nums, k, index + 1, list);
        list.remove(list.size() - 1);
        int notPick = solve(nums, k, index + 1, list);
        return pick + notPick;
    }

    private static boolean check(List<Integer> list, int k) {
        int n = list.size();
        HashSet<Integer> set = new HashSet<>(list);
        for (int i = 0; i < n; i++) {
            if (set.contains(list.get(i) - k) || set.contains(list.get(i) + k)) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(List<Integer> list, int num, int k) {
        if (list.isEmpty()) return true;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (Math.abs(num - list.get(i)) == k) {
                return false;
            }
        }
        return true;
    }

    public static int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        String str = Integer.toBinaryString(n);
        int len = str.length();
        int num = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            num++;
        }
        return new int[]{even, odd};
    }


}
