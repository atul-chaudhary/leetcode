package com.atul.practise;

import java.util.ArrayList;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = Integer.MIN_VALUE;
        //kadane's algorith
        //int max = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=0;i< arr.length;i++){
            curSum+=arr[i];
            if(curSum < arr[i]){
                curSum = arr[i];
            }
           max =  Math.max(max, curSum);
        }
        System.out.println(max);

        //second optimised approach
//        for (int i = 0; i < arr.length; i++) {
//            int cur = 0;
//            for (int j = i; j < arr.length; j++) {
//                cur += arr[j];
//                max = Math.max(max, cur);
//            }
//        }

//        int max = Integer.MIN_VALUE;
//        for(int i=0;i< result.size();i++){
//            int cur = 0;
//            for (int j = 0; j < result.get(i).size(); j++) {
//                cur += result.get(i).get(j);
//                max = Math.max(max,cur);
//            }
//        }

        //System.out.println(max);
    }
}
