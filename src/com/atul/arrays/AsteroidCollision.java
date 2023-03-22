package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] nums = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }

    public static int[] asteroidCollision(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < n) {
            int num = nums[index];
            if (stack.isEmpty()) {
                stack.push(num);
                index++;
            } else if (stack.peek() > 0 && num > 0) {
                stack.push(num);
                index++;
            } else if (stack.peek() > 0 && num < 0) {
                int convert = Math.abs(num);
                int last = stack.pop();
                if (convert == last) {
                    index++;
                    continue;
                }
                int big = Math.max(last, convert);
                if (big == last) {
                    stack.push(big);
                    index++;
                }
            } else if (stack.peek() < 0 && num > 0) {
                stack.push(num);
                index++;
            } else if (stack.peek() < 0 && num < 0) {
                stack.push(num);
                index++;
            }
        }

        List<Integer> result = new ArrayList<>(stack);
        int size = result.size();
        int[] finalResult = new int[size];
        for (int i = 0; i < size; i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }
}
