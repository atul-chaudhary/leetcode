package com.atul.dynamic_programming;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = {9,8,1,7,6,5,4,3,2,1};
        System.out.println(solve(arr));
    }

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        //step:1 find the longest increasing subsequences till i
        int[] lis = new int[n];

        for (int i = 0; i < n; i++){
            int max = 1;
            for (int j = 0;j <i; j++){
                if (nums[j] < nums[i]){
                    max = Math.max(max, lis[j] + 1);
                }
            }
            lis[i] = max;
        }

        //step : 2 find longest decreasing subsequence starting from i
        int[] lds = new int[n];
        for (int i = n-1; i >= 0; i--){
            int max = 1;
            for (int j = i+1; j < n; j++){
                if (nums[i] > nums[j]){
                    max = Math.max(max, lds[j]+ 1);
                }
            }
            lds[i] = max;
        }

		int lbs = 0;
        for (int i = 0; i < n; i++){
            if (lis[i] > 1 && lds[i] > 1)
                lbs = Math.max(lis[i] + lds[i]-1, lbs);
        }
        //step 4: min remove is size of the original array - the length of the longest bitonic              subsequence found
        return n - lbs;
    }

    private  static int solve(int[] arr){
        int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for(int i=0;i<n;i++){
            for(int prev = 0; prev < i; prev++){
                if(arr[prev] < arr[i] && 1+ dp1[prev] > dp1[i]){
                    dp1[i] =  1+ dp1[prev];
                }
            }
        }
        System.out.println(Arrays.toString(dp1));
        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);
        int maxi = 1;
        for(int i = n-1;i>=0;i--){
            for(int prev = n-1;prev>i;prev--){
                if(arr[prev] < arr[i] && 1+dp2[prev] > dp2[i]){
                    dp2[i] = 1+ dp2[prev];
                }
            }
            if(dp1[i] > 1 && dp2[i] > 1){ // This case is used to prevent Strictly Increasing/Decreasing to be considered as for mountain it is not needed
                maxi = Math.max(maxi,(dp1[i]+dp2[i])-1);
            }
        }
        return n-maxi;
    }
}
