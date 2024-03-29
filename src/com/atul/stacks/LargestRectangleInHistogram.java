package com.atul.stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};//{2,1,5,6,2,3};
        System.out.println(largestRectangleAreaOptimal(arr));
    }

    public static int largestRectangleAreaOptimal(int[] arr) {
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];
        Stack<int[]> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        //0 consist of val
        //1 consist of indexhu
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()[0] >= arr[i]) stack.pop();
            if(stack.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = stack.peek()[1];
            }
            int[] temp = new int[2];
            temp[0] = arr[i];
            temp[1] = i;
            stack.push(temp);
        }
        stack.clear();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0] >= arr[i]) stack.pop();
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stack.peek()[1];
            }
            int[] temp = new int[2];
            temp[0] = arr[i];
            temp[1] = i;
            stack.push(temp);
        }

        System.out.println(Arrays.toString(nsl));
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]*(nsr[i]-nsl[i]-1));
        }
        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int exten = heights[i];
            int count = 1;
            for (int j = i-1; j >=0 ; j--) {
                if(exten <= heights[j]){
                    count++;
                }else{
                    break;
                }
            }

            for (int j = i+1; j < heights.length; j++) {
                if(exten <= heights[j]){
                    count++;
                }else{
                    break;
                }
            }
            //System.out.println(exten*count);
            max = Math.max(max, exten*count);
        }
        return max;
    }
}
