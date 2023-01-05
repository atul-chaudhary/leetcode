package com.atul.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindGoodDaysToRobtheBank {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(goodDaysToRobBank(nums, 1));
    }

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                result.add(i);
            }
        }
        return result;
    }

}
