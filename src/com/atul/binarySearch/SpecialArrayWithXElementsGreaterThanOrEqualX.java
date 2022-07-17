package com.atul.binarySearch;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        int[] arr = {0,5,0,1,8,3,0,1};
        System.out.println(specialArray(arr));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = -1;
        for (int i = 0; i < nums[n - 1]; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i) {
                    count++;
                    if (count > i) {
                        break;
                    }
                }
            }
            //System.out.println(count);
            if (count == i) {
                result = i;
                //break;
            }
        }
        return result;
    }
}
