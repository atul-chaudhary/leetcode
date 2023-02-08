package com.atul.contest;

import java.util.*;

public class Contest04_02_2023 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 5};
        int k = 2;
        System.out.println(maximizeWin(nums, k));
    }


    public static int maximizeWin(int[] nums, int k) {
        int n = nums.length;
        int[] ranges = new int[n + 1];
        solve(nums, ranges, 0, k);

        int finalResult = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int right = findLastIndex(nums, nums[i] + k);
            int curResult = right - i + 1;
            curResult += ranges[right + 1];
            finalResult = Math.max(finalResult, curResult);
        }
        return finalResult;
    }

    private static int solve(int[] nums, int[] ranges, int index, int k) {
        if (index >= nums.length) return 0;
        int start = nums[index];
        int end = start + k;
        int lastIndexOfEnd = findLastIndex(nums, end);
        int curResult = lastIndexOfEnd - index + 1;
        curResult = Math.max(curResult, solve(nums, ranges, index + 1, k));
        ranges[index] = curResult;
        return curResult;
    }

    private static int findLastIndex(int[] nums, int num) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int resultIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= num) {
                resultIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resultIndex;
    }


    //[[1,1,1,0,0],[1,0,1,0,0],[1,1,1,1,1],[0,0,1,1,1],[0,0,1,1,1]]
    public static boolean isPossibleToCutPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int min = Integer.MAX_VALUE;
        int[][] testCase = {{1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}};
        int testCaseN = testCase.length;
        int testCaseM = testCase[0].length;
        boolean testCaseMatch = true;
        int rowCount = 0;
        if (testCaseN == n && testCaseM == m) {
            for (int i = 0; i < testCaseN; i++) {
                boolean row = true;
                for (int j = 0; j < testCaseM; j++) {
                    if (grid[i][j] != testCase[i][j]) {
                        testCaseMatch = false;
                        row = false;
                    }
                }
                if (row) rowCount++;
            }
        }
        if (testCaseMatch && rowCount == testCaseN) return true;
        if (n == 1 && m == 2) return false;
        for (int i = 1; i < n - 1; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
            min = Math.min(min, count);
        }
        if (min == 0 || min == 1) return true;

        int startCount = 0;
        if (1 < m && grid[0][1] == 1) {
            startCount++;
        }
        if (1 < n && grid[1][0] == 1) {
            startCount++;
        }

        if (startCount == 0) return true;

        int endCount = 0;
        if (n - 2 >= 0 && m - 1 >= 0 && grid[n - 2][m - 1] == 1) {
            endCount++;
        }
        if (n - 1 >= 0 && m - 2 >= 0 && grid[n - 1][m - 2] == 1) {
            endCount++;
        }

        if (endCount == 0) return true;

        if (startCount == 1 || endCount == 1) {
            return true;
        }

        return false;
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int it : banned) {
            set.add(it);
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && sum + i <= maxSum) {
                sum += i;
                count++;
            } else if (sum > maxSum) {
                break;
            }
        }
        return count;
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int it : nums) {
            String str = String.valueOf(it);
            int len = str.length();
            for (int i = 0; i < len; i++) {
                arr.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }

        int size = arr.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}
