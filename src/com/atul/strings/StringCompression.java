package com.atul.strings;

import java.util.*;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(strStr(str, "aaaa"));
    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i < n; i++) {
            char ch = haystack.charAt(i);
            if (ch == needle.charAt(0)) {
                int indexHay = i + 1;
                int indexNeed = 1;
                boolean flag = true;
                while (indexHay < n && indexNeed < m) {
                    if (haystack.charAt(indexHay++) != needle.charAt(indexNeed++)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && indexNeed >= m) {
                    return i;
                }
            }
        }
        return -1;
    }

    static long solve(long a, long b, long N) {
        long lcm = (a * b) / gcd(a, b);
        return lcm * N;
    }

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = prices[i];
            int index = -1;
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= cur) {
                    index = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                result[i] = cur - prices[index];
            } else {
                result[i] = cur;
            }
        }
        return result;
    }

    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();

        String row1 = "qwertyuiop";
        for (int i = 0; i < row1.length(); i++) {
            map.put(row1.charAt(i), 1);
        }
        String row2 = "asdfghjkl";
        for (int i = 0; i < row2.length(); i++) {
            map.put(row2.charAt(i), 2);
        }
        String row3 = "zxcvbnm";
        for (int i = 0; i < row3.length(); i++) {
            map.put(row3.charAt(i), 3);
        }
        List<String> result = new ArrayList<>();
        for (String item : words) {
            String it = item.toLowerCase();
            int size = it.length();
            int cur = map.get(it.charAt(0));
            boolean flag = true;
            for (int i = 1; i < size; i++) {
                if (map.get(it.charAt(i)) != cur) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(item);
            }
        }

        int si = result.size();
        String[] finalResult = new String[si];
        for (int i = 0; i < si; i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    public static int compress(char[] nums) {
        int n = nums.length;
        int len = 0;
        int k = 0;
        for (int index = 0; index < n; index++) {
            char ch = nums[index];
            int count = 1;
            while (index + 1 < n && nums[index + 1] == ch) {
                index++;
                count++;
            }
            len++;
            nums[k++] = ch;
            if (count == 1) continue;
            if (count > 9) {
                String str = String.valueOf(count);
                for (int i = 0; i < str.length(); i++) {
                    len++;
                    nums[k++] = str.charAt(i);
                }
            } else {
                len++;
                nums[k++] = String.valueOf(count).charAt(0);
            }
        }
        return len;
    }
}
