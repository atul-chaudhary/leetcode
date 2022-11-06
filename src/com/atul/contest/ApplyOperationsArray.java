package com.atul.contest;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ApplyOperationsArray {
    public static void main(String[] args) {
        int[] arr = {847,847,0,0,0,399,416,416,879,879,206,206,206,272};
        System.out.println(Arrays.toString(applyOperations(arr)));

    }

    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *=2;
                nums[i+1] = 0;
            }
        }
        int j =0;
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0) {
                result[j++] = nums[i];
            }
        }
        return result;
    }
}
