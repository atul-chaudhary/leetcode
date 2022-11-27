package com.atul.sorting;

import java.util.*;

public class sum4 {
    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(arr, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int num = nums[i];
            int newtar = target-num;
            for(int j=i+1;j<n;j++){
                int temp = nums[j];
                int left = j+1;
                int right = n-1;
                while(left < right){
                    long cal = temp+nums[left]+nums[right];
                    if(cal == newtar){
                        List<Integer> list = new ArrayList<>();
                        list.add(num);
                        list.add(temp);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(right > left && nums[right]==nums[right-1]) right--;

                        left++;
                        right--;

                    }else if(cal < newtar){
                        left++;
                    }else if(cal > newtar){
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
