package com.atul.dynamic_programming;

import java.util.Arrays;

public class LongesCommonSubString {
    public static void main(String[] args) {
        String s = "aacabbbabacc";
        String b = "bba";
//        int[][] dp = new int[s.length() + 1][b.length() + 1];
//        int[] max = new int[1];
//        int len = LongestCommonSubStringMemo(s, b, s.length(), b.length(), 0, dp, max);
//        for(int[] row : dp){
//            System.out.println(Arrays.toString(row));
//        }
//        int row = s.length();
//        int col = b.length();
//        String resultStr  ="";
//        while (dp[row][col] != 0) {
//            resultStr = s.charAt(row - 1) + resultStr; // or Y[col-1]
//            --len;
//
//            // move diagonally up to previous cell
//            row--;
//            col--;
//        }
//        System.out.println(resultStr);
        System.out.println(lcs(s.toCharArray(), b.toCharArray(), s.length(), b.length(),0));
        System.out.println(LongestCommonSubString(s, b, s.length(), b.length(),  0));
    }


    public static int LongestCommonSubStringMemo(String x, String y, int n, int m, int curr_max, int[][] dp, int[] max) {
        if (m == 0 || n == 0) return curr_max;

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = LongestCommonSubStringMemo(x, y, n -1, m - 1, curr_max + 1, dp, max);
            max[0] = Math.max(max[0], dp[n][m]);
            return dp[n][m];

        } else {
            Math.max(LongestCommonSubStringMemo(x, y, n - 1, m, 0, dp, max), LongestCommonSubStringMemo(x, y, n, m - 1, 0, dp, max));
            //max[0] = Math.max(max[0], dp[n][m]);
            return dp[n][m] = 0;
        }

        //return max[0];
    }

    private static int lcs(char[] a, char[] b, int i, int j, int count) {
        if (i == 0 || j == 0)
            return count;
        if (a[i - 1] == b[j - 1]) {
            count = lcs(a, b, i - 1, j - 1, count + 1);
        }
        count = Math.max(count, Math.max(lcs(a, b, i, j - 1, 0), lcs(a, b, i - 1, j, 0)));
        return count;
    }

    public static int LongestCommonSubString(String x, String y, int m, int n, int curr_max) {
        if (m == 0 || n == 0) return curr_max;
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return LongestCommonSubString(x, y, m - 1, n - 1, curr_max + 1);
        } else {
            return Math.max(curr_max, Math.max(LongestCommonSubString(x, y, m , n-1, 0), LongestCommonSubString(x, y, m-1, n, 0)));
        }
    }
}
