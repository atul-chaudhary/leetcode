package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays13 {
    public static void main(String[] args) {
        allSubStrings("abc");
        allSubArrays(new int[]{1,2,3});
    }

    public static void allSubStrings(String nums) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length(); i++) {
            for (int j = i; j < nums.length(); j++) {
                arrayList.add(nums.substring(i, j + 1));
            }
        }
        System.out.println(arrayList);
    }

    public static void allSubArrays(int[] nums) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                arrayList.add(createSubArray(i, j, nums));
            }
        }
        System.out.println(arrayList);
    }

    public static ArrayList createSubArray(int start, int end, int[] nums) {
        ArrayList arrayList = new ArrayList();
        if (start == end) {
            arrayList.add(nums[start]);
            return arrayList;
        } else {
            for (int i = start; i <= end; i++) {
                 arrayList.add(nums[i]);
            }
            return arrayList;
        }
    }
}
