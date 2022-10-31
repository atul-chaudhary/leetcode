package com.atul.contest;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIV {
    public static void main(String[] args) {
        int[] nums = {2,4,0,9,6};
        //System.out.println(Arrays.toString(secondGreaterElement(nums)));
        //System.out.println(15/2);
        System.out.println(Arrays.toString(getNextGreater(nums, nums.length)));
    }

    private static int[] getNextGreater(int[] arr, int n){
        Stack<Integer> s = new Stack<>();
        int[] output = new int[n];
        s.push(0);
        for (int i = 1; i < n; i++) {
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                output[s.peek()] = arr[i];
                s.pop();
            }
            count = 0;
            s.push(i);
        }
        while(!s.empty()){
            output[s.peek()] = -1;
            s.pop();
        }
        return output;
    }

    static int count = 0;
    private boolean solve(Stack<Integer> s, int[] arr, int i){
        if(arr[s.peek()] < arr[i]){
            count++;
            return true;
        }
        return false;
    }

}
