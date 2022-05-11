package com.atul.arrays;

import java.util.Arrays;

public class KadanesAlgo {

    public static void main(String[] args) {
        int[]  arr = {-2,1,-3,4,-1,2,1,-5,4};
        int result = kadanesAlgo(arr);
        System.out.println(result);
    }

    private static int kadanesAlgo(int[] arr) {
        int[] temp = new int[arr.length];
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                temp[i] = arr[i];
            }else {
                int currentBest = Math.max(temp[i-1]+ arr[i] , arr[i]);
                temp[i] = currentBest;
                best = Math.max(best, currentBest);
            }
        }
        return best;
    }
}
