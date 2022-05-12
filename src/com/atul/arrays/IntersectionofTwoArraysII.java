package com.atul.arrays;

import java.util.ArrayList;

public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 2, 1};
//        int[] arr2 = {2, 2};
//        intersect(arr1, arr2);

        int[] arr1 = {1, 1, 2, 2};
        int[] arr2 = {2, 2};
        intersectFollowUpFirst(arr1, arr2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    arrayList.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        //System.out.println(arrayList);
        return arrayList.stream().mapToInt(i -> i).toArray();
    }

    public static int[] intersectFollowUpFirst(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < nums1.length; i++) {
            if (nums2[0] == nums1[i]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        arrayList.add(nums1[i]);
                        nums2[j] = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(arrayList);
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
