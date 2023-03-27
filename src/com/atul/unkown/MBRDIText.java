package com.atul.unkown;

import com.sun.xml.internal.ws.developer.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

public class MBRDIText {

    public static void main(String[] args) {
        int a =1;
        int b = 2;
        a += ++a-  b-- + b++;
        System.out.println(a);
    }


    private static int t(int i, int j, Map<String, Integer> cache, int[] arr) {
        if (i >= j) {
            return 0;
        }

        String key = i + "|" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result = arr[j] - arr[i] + Math.min(t(i, j - 1, cache, arr), t(i + 1, j, cache, arr));
        cache.put(key, result);
        return result;
    }

    private static long solve(List<List<Integer>> nums) {
        int size = nums.size();
        System.out.println(size + "<<>>");
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int len = nums.get(i).size();
            List<Integer> temp = nums.get(i);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            long dis = 0;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, temp.get(j));
                max = Math.max(max, temp.get(j));
                dis += max - min;
            }
            if (dis < ans) {
                ans = dis;
                System.out.println(temp + "<<>>");
            }
        }
        return ans;
    }

    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
}
