package com.atul.arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        for (int i = n-2; i >=0; i--) {
            suf[i] = suf[i+1]*nums[i];
        }
        int num = 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if(i>0)
                pre[i]= nums[i] * pre[i-1];
            if(i-1 >= 0) num *= pre[i-1];
            if(i+1 < n) num *= suf[i+1];
            result[i] = num;
            num = 1;
        }
        return result;
    }
}
