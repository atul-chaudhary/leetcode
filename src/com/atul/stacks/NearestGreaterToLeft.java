package com.atul.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(NGL(arr)));
    }

    public static int[] NGL(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()){
                result[i] = -1;
            }else if(!stack.isEmpty() && stack.peek() > arr[i]){
                result[i] = stack.peek();
            }else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while (stack.size() > 0 && stack.peek() <= arr[i]) stack.pop();

                if(stack.isEmpty()){
                    result[i] = -1;
                }else {
                    result[i]  = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
