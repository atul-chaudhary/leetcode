package com.atul.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllGoodIndices {
    public static void main(String[] args) {
        int[] nums = {478184,863008,716977,921182,182844,350527,541165,881224};
        int k = 1;
        System.out.println(goodIndices(nums, k));
    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = suffix[n-1] = 1;
        for(int i=1;i<n;i++){
            if(nums[i] <= nums[i-1]){
                prefix[i] = prefix[i-1] + 1;
            }else{
                prefix[i] = 1;
            }
        }
        //System.out.println(Arrays.toString(prefix));
        for(int i=n-2;i>=0;i--){
            if(nums[i] <= nums[i+1]){
                suffix[i] = suffix[i+1]+1;
            }else{
                suffix[i] = 1;
            }
        }
        //System.out.println(Arrays.toString(suffix));
        List<Integer> result = new ArrayList<>();
        for(int i=k;i<n-k;i++){
            if(prefix[i-1] >= k && suffix[i+1] >= k){
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isValid(int[] nums, int k, int num){
        boolean isPrev = true;
        boolean isAfter = true;

        for (int i = num-k+1; i < num ; i++) {
            if(nums[i] > nums[i-1]) {
                isPrev = false;
                break;
            }
        }

        for (int i = num+2; i <= num+k; i++) {
            if(nums[i] < nums[i-1]){
                isAfter = false;
                break;
            }
        }

        return isAfter && isPrev;
    }
}
