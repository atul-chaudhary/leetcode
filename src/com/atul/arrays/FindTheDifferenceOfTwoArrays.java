package com.atul.arrays;
import java.util.*;
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int it : nums1){
            set1.add(it);
        }
        for(int it : nums2){
            set2.add(it);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        for (int it : set1){
            if(!set2.contains(it)) result1.add(it);
        }

        for (int it : set2){
            if(!set1.contains(it)) result2.add(it);
        }
        result.add(result1);
        result.add(result2);
        return result;
    }
}
