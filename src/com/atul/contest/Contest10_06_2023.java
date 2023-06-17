package com.atul.contest;

import java.util.*;

public class Contest10_06_2023 {
    public static void main(String[] args) {
        String str = "1111111";
        System.out.println(longestSemiRepetitiveSubstring(str));
    }

    public static int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            String str = s.substring(i);
            int temp = solve(str);
            //System.out.println(temp);
            result = Math.max(result, temp);
        }
        return result;
    }

    public static int solve(String s) {
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int count = 0;
        boolean isConseFound = false;
        for (int i = 0; i < n; i++) {
            count++;
            int it = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (map.containsKey(it) && map.get(it) == i - 1 && isConseFound == false) {
                isConseFound = true;
                map.put(it, i);
            } else if (map.containsKey(it) && map.get(it) == i - 1 && isConseFound) {
                isConseFound = false;
                map.clear();
                map.put(it, i);
                result = Math.max(result, count - 1);
                count = 1;
            } else {
                map.put(it, i);
            }
        }
        if (result == 0) result = count;
        return result;
    }

    public static boolean isFascinating(int n) {
        String str = String.valueOf(n);
        str += String.valueOf(2 * n);
        str += String.valueOf(3 * n);
        Map<Integer, Integer> map = new TreeMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int it = Integer.parseInt(String.valueOf(str.charAt(i)));
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        System.out.println(map);
        for (int i = 1; i <= 9; i++) {
            if (!map.containsKey(i) || map.get(i) >= 2) {
                return false;
            }
        }

        return true;
    }

    /*public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[i] = nums[i] + grid[i][j];

                if (nums[i] <=)
            }
        }
    } */
}
