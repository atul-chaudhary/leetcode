package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        int[] arr  = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //best approach withiout using extra space
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int mark = Math.abs(nums[i]) - 1;
            if (nums[mark] > 0) {
                nums[mark] = nums[mark] * -1;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
