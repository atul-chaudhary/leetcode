package com.atul.greedy;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        System.out.println(nse(nums));
    }

    private static int nse(int[] nums){
        int n = nums.length;
        int[] nsr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) nsr[i] = n-i;
            else nsr[i] = Math.abs(stack.peek()-i);
            stack.push(i);
        }
        stack.clear();
        int[] nsl = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();
            if (stack.isEmpty()) nsl[i] = i+1;
            else nsl[i] = Math.abs(i-stack.peek());
            stack.push(i);
        }
        long mod = (long) 1e9 +7;
        long result = 0;
        for (int i = 0; i < n; i++) {
            result+=(long) nums[i]*nsl[i]*nsr[i];
            result%=mod;
        }
        return (int)result;
    }

    public static int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            int num = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > arr[i]) {
                    num = Math.min(num, arr[j]);
                    index = j;
                }
            }
            if (index != -1) {
                char temp = arr[i];
                arr[i] = (char) num;
                arr[index] = temp;
                String actualNum = new String(arr);
                String num1 = actualNum.substring(0,i+1);
                String num2 = actualNum.substring(i+1);
                char[] numArr = num2.toCharArray();
                Arrays.sort(numArr);
                String newNum = num1+new String(numArr);
                long number = Long.parseLong(newNum);
                long intMax = Integer.MAX_VALUE;
                return number <= intMax ? (int) number : -1;
            }
        }
        return -1;
    }
}