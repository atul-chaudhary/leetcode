package com.atul.contest;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIV {
    public static void main(String[] args) {
        int[] nums = {2,4,0,9,6};
        //System.out.println(Arrays.toString(secondGreaterElement(nums)));
        //System.out.println(15/2);
        System.out.println(makeIntegerBeautiful(1, 1));
    }

    public static long makeIntegerBeautiful(long n, int target) {
        long i = 0;
        while(true){
            if(sum(n+i) <= target){
                return i;
            }
            i++;
        }
    }

    private static int sum(long n){
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int sum = 0;
        for(char ch : arr){
            sum+= (int) ch-'0';
        }
        return sum;
    }

    public static int[] secondGreaterElement(int[] nums) {
        return getNextGreater(nums, nums.length);
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
