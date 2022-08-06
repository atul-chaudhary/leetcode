package com.atul.contest;

import java.util.Arrays;

public class MaximumMultiple {
    public static void main(String[] args) {
        int [] arr = {-11 ,8, 10 ,9 ,-19 ,-8 ,19, -14};
        System.out.println(maximumMultiple(8, arr));
    }

    public static long maximumMultiple(int N, int[] A) {
        // code here
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int i=0;
        int j= A.length-1;
        int k = N/2;
        long max = Long.MIN_VALUE;
        while(i<j && k > 0){
            long l = (long) A[i]* A[j];
            if(max < l){
                max = l;
            }
            i++;
            j--;
            k--;
        }
        return max;
    }
}
