package com.atul.contest;

import java.util.HashSet;

public class FindSubarraysWithEqualSum {
    public static void main(String[] args) {
        int[] arr = {0,0,0};
        //System.out.println(Integer.parseInt("9", 2));
        System.out.println(findSubarrays(arr));
        System.out.println(convertFromBaseToBase("9", 10,2));
    }

    public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }

    public static boolean findSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        int k = 2;
        HashSet<Integer> set = new HashSet<>();
        int cur_sum = 0;
        for (int i = 0; i < n; i++) {
            cur_sum += nums[i];
            count++;
            if(count == k){
                if(set.contains(cur_sum)){
                    return true;
                }
                set.add(cur_sum);
                count--;
                cur_sum -= nums[i-k+1];
            }
        }
        return false;
    }
}
