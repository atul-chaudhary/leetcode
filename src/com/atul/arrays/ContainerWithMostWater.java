package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,1};
        //System.out.println(maxArea(arr));
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int max = 0;
        while(left < right){
            int num = 0;
            if(arr[left] < arr[right]){
                num = arr[left];
                left++;
            }else {
                num = arr[right];
                right--;
            }
            max = Math.max(max, num * (right - left +1));
        }
        return max;
    }

    public static int maxArea(int[] arr) {
        int n = arr.length;
        int[] left= new int[n];
        int[] right = new int[n];

        int max = arr[0];
        for(int i=0;i<n;i++){
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        System.out.println(Arrays.toString(left));
        max = arr[n-1];
        for(int i=n-1;i>=0;i--){
            max = Math.max(max, arr[i]);
            right[i] = max;
        }
        System.out.println(Arrays.toString(right));
        int l = 0;
        int r = n-1;
        int result = 0;
        for(int i=0;i<n;i++){
            int num = 0;
            if(left[l] < right[r]){
                l++;
                num = left[l];
            }else{
                r--;
                num = right[r];
            }
            int nn = (r-l+1);
            result = Math.max(result, num * nn);
            //System.out.println(result);
        }
        return result;
    }

}
