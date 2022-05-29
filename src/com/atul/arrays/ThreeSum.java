package com.atul.arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        list.add(temp);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(list));
    }
}
