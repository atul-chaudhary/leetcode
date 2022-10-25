package com.atul.contest;

import java.util.ArrayList;
import java.util.List;

public class NumberSubarraysWithGCD {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 2, 6, 3};
        System.out.println(subarrayGCD(arr, 3));
    }

    public static int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = 0;
            for (int j = i; j < nums.length; j++) {
                gcd = gcd(gcd, nums[j]);
                if(gcd == k){
                    count++;
                }
            }
        }
        return count;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
