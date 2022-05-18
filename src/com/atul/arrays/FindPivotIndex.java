package com.atul.arrays;

import java.util.Arrays;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {-1,-1,0,1,1,0};//{1,2,3};//{1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] top = new int[len];
        int[] bottom = new int[len];
        int count = 0;
        for(int i=0;i<len;i++){
            count +=nums[i];
            top[i] = count;
        }
        count = 0;
        System.out.println(Arrays.toString(top));
        for(int i=len-1; i>=0;i--){
            count += nums[i];
            bottom[i] = count;
        }
        count = 0;
        System.out.println(Arrays.toString(bottom));
        for(int i=0;i<len;i++){
            if(top[i]==bottom[i]){
                //if(i==0 || i== len-1) return 0;
                return i;
            }
        }
        return -1;
    }
}
