package com.atul.arrays;

import java.util.HashMap;

public class Arrays12 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i=0;i< nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                return true;
            }else {
                hashMap.put(nums[i], 1);
            }
        }
        return false;
    }

}
