package com.atul.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Contest26_11_22 {
    public static void main(String[] args) {
        String s = "YYYY";
        System.out.println(bestClosingTime(s));
        Map<Integer, int[]> map = new HashMap<>();
    }

    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int[] pre_yes = new int[n];
        int[] pre_no = new int[n];
        int yes = 0;
        int no = 0;
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                yes++;
            }
            if (customers.charAt(j) == 'N') {
                no++;
            }
            pre_no[j++] = no;
            pre_yes[i] = yes;
        }
        int index = -1;
        int min = pre_yes[0];
        for (int i = 0; i <= n; i++) {
            if (i < n) {
                int n0 = 0;
                if (i > 0) n0 = pre_no[i - 1];
                int cal = (pre_yes[i]) + n0;
                if (cal < min) {
                    min = cal;
                    index = i;
                }
            } else {
                int cal = pre_no[i - 1];
                if (cal < min) {
                    min = cal;
                    index = i;
                }
            }
        }
        return index == -1 ? 0 : index;
    }

    public static int[][] onesMinusZeros(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[] oneCols = new int[m];
        int[] zeroCols = new int[m];


        int[] oneRows = new int[n];
        int[] zeroRows = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    oneRows[i]++;
                    oneCols[j]++;
                } else {
                    zeroCols[j]++;
                    zeroRows[i]++;
                }
            }
        }
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = oneRows[i] + oneCols[j] - zeroRows[i] - zeroCols[j];
            }
        }
        return diff;
    }
}
