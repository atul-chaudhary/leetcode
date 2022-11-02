package com.atul.contest;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIV {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nge(nums)));
        System.out.println(Arrays.toString(circularNGE(nums)));
    }

    public static int[] circularNGE(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2*n];
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
            arr[i+n] = nums[i];
        }
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i%n] = -1;
            }else{
                result[i%n] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    private static int[] nge(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);

        }
        return result;
    }

    private static int[] getNextGreater(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] output = new int[n];
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                output[s.peek()] = arr[i];
                s.pop();
            }
            count = 0;
            s.push(i);
        }
        while (!s.empty()) {
            output[s.peek()] = -1;
            s.pop();
        }
        return output;
    }

    static int count = 0;

    private boolean solve(Stack<Integer> s, int[] arr, int i) {
        if (arr[s.peek()] < arr[i]) {
            count++;
            return true;
        }
        return false;
    }

}
