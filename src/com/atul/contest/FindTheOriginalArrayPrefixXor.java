package com.atul.contest;

import java.util.Arrays;

public class FindTheOriginalArrayPrefixXor {
    public static void main(String[] args) {
        int[] arr= {5,2,0,3,1};
        System.out.println(Arrays.toString(findArray(arr)));
        System.out.println((int)1e9 +7);
    }

    public static int[] findArray(int[] pref) {
        int n= pref.length;
        int[] result = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if(i==0){
                result[i] = pref[i];
                prev = result[i];
            }else {
                result[i] = prev ^ pref[i];
                prev = prev ^ result[i];
            }
        }
        return result;
    }
}
