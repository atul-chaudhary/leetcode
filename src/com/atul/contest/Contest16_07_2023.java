package com.atul.contest;

import java.util.*;

public class Contest16_07_2023 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 2);
        System.out.println(minimumIndex(list));
    }

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                ans += (nums[i] * nums[i]);
            }
        }
        return ans;
    }

    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] += k;
            max = Math.max(max, nums[i]);
        }
        int[] prefix = new int[max + k + 2];
        for (int i = 0; i < n; i++) {
            int first = nums[i] - k;
            int last = nums[i] + k;
            prefix[first]++;
            prefix[last + 1]--;
        }
        int total = 0;
        int ans = 1;
        for (int i = 0; i < prefix.length; i++) {
            total += prefix[i];
            ans = Math.max(ans, total);
        }
        return ans;
    }


    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxNum = 0;
        int maxFre = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int fre = entry.getValue();
            if (fre > maxFre) {
                maxNum = key;
                maxFre = fre;
            }
        }
        //System.out.println(maxNum + "<<>>");
        int[] pref = new int[n];
        int[] suf = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num == maxNum) {
                count++;
            }
            pref[i] = count;
        }
        //System.out.println(Arrays.toString(pref) + "<<>>");
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums.get(i);
            if (num == maxNum) {
                count++;
            }
            suf[i] = count;
        }
        //System.out.println(Arrays.toString(suf) + "<<>>");
        int ans = -1;
        for (int i = 0; i < n - 1; i++) {
            int num = nums.get(i);
            if (num == maxNum) {
                int firstSize = i + 1;
                int lastSize = n - i - 1;
                //      System.out.println(firstSize + "<<>>" + lastSize);
                if (pref[i] * 2 <= firstSize || suf[i + 1] * 2 <= lastSize) {
                    continue;
                }
                ans = i;
                break;
            }
        }
        return ans;
    }
}
