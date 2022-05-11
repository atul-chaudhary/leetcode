package com.atul.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
//        int[]  nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums1 = {1, 5, 9, 10, 15, 20};
//        int m = nums1.length;
//        int[] nums2 = {2, 3, 8, 13};
//        int n = nums2.length;
//        mergeVariation(nums1, m, nums2, n);

        //for checking the merge of two arrays without the
        int[] nums1 = {1, 5, 9, 10, 15, 20};
        int m = nums1.length;
        int[] nums2 = {2, 3, 8, 13};
        int n = nums2.length;
        mergeWithoutExtraSpace(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int k = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[k--] = nums1[p1--];
            } else {
                nums1[k--] = nums2[p2--];
            }
        }
    }

    //one new variation
    public static void mergeVariation(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, k = 0;
        int[] arr = new int[m + n];
        for (int i = 0; i < arr.length; i++) {
            if (p1 < m && p2 < n) {
                if (nums1[p1] < nums2[p2]) {
                    arr[i] = nums1[p1++];
                } else {
                    arr[i] = nums2[p2++];
                }
            } else if (p1 < m) {
                arr[i] = nums1[p1++];
            } else {
                arr[i] = nums2[p2++];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //merging two arrays based on
    public static void mergeWithoutExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i< m;i++){
            if(nums1[i] > nums2[0]){
                int temp =  nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                //System.out.println(Arrays.toString(nums1));
            }
            //System.out.println(Arrays.toString(nums1));
            for (int j = 0; j < n-1; j++) {
                if(nums2[j] > nums2[j+1]){
                    int temp = nums2[j];
                    nums2[j] = nums2[j+1];
                    nums2[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

}
