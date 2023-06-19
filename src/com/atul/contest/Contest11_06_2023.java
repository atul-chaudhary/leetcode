package com.atul.contest;

import java.util.*;

public class Contest11_06_2023 {
    public static void main(String[] args) {
        String str = "aa";
        System.out.println(smallestString(str));
    }

    public static String smallestString(String s) {
        int n = s.length();

        if (n == 1) {
            if (s.charAt(0) == 'a') {
                return String.valueOf('z');
            }
            int prev = s.charAt(0) - 1;
            return String.valueOf((char) prev);
        }
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                if (count >= 1) {
                    break;
                }
                continue;
            }
            count++;
            int prev = s.charAt(i) - 1;
            sb.replace(i, i + 1, String.valueOf((char) prev));
        }
        if(count == 0){
            return sb.replace(n-1, n, String.valueOf('z')).toString();
        }
        return sb.toString();
    }

    public static long equalPairs(String str) {
        long result = -1;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int j = i; j < i + 10; j++) {
                    char temp = str.charAt(j);
                    if (temp >= '0' && temp <= '9') {
                        count++;
                        sb.append(temp);
                    }
                }
                if (count == 10) {
                    return Long.parseLong(sb.toString());
                }
            }
        }
        return result;
    }

    public int findNonMinOrMax(int[] nums) {
        int len = nums.length;
        if (len == 1 || len == 2) return -1;
        Arrays.sort(nums);
        return nums[1];
    }

    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < n) {
            String temp = String.valueOf(nums[index]);
            int curIndex = index;
            int cur = curIndex + 1;
            boolean f = false;
            while (cur < n && nums[curIndex] + 1 == nums[cur]) {
                curIndex++;
                cur++;
                f = true;
            }

            if (f) {
                index = cur;
                if (curIndex < n && Integer.parseInt(temp) != nums[curIndex]) {
                    temp += "->" + nums[curIndex];
                }
            } else {
                index++;
            }
            result.add(temp);
        }
        return result;
    }

}
