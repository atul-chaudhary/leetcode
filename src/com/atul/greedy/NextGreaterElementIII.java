package com.atul.greedy;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        int n = 21;
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(14);
        System.out.println(stack.elementAt(1));
        System.out.println(nextGreaterElement(n));
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