package com.atul.contest;

import java.util.Arrays;

public class Contest04_03_2023 {
    public static void main(String[] args) {
        System.out.println(splitNum(687));
    }



    public static int splitNum(int num) {
        String str = String.valueOf(num);
        char[] nums = str.toCharArray();
        Arrays.sort(nums);
        int n = nums.length;
        String num1 = "";
        String num2 = "";
        for (int i = 0; i < n; i = i + 2) {
            num1 += nums[i];
            if (i + 1 < n)
                num2 += nums[i + 1];
        }

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        return n1 + n2;
    }

    public static long coloredCells(int n) {
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            curr += ((i - 1) * 4.0);
        }
        return curr;
    }

}
