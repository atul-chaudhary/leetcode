package com.atul.greedy;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIV {
    public static void main(String[] args) {
        int[] arr = {1,17,18,0,18,10,20,0};
        System.out.println(Arrays.toString(secondGreaterElementOpt(arr)));
    }

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

    public static int[] secondGreaterElementOpt(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i])stack.pop();
            if (!stack.isEmpty()) nge[i] = stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(nge));
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            int l = nge[i] + 1;
            while(l < n && nums[i] >= nums[l]){
                l = nge[l];
            }
            if(l >= n)  out[i] = -1;
            else out[i] = nums[l];
        }
        return out;
    }

    public static int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        Pair[] result = new Pair[n];
        Stack<Pair> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = new Pair(-1, -1);
            } else result[i] = new Pair(stack.peek().val, stack.peek().index);

            stack.push(new Pair(nums[i],i));
        }
        System.out.println(Arrays.toString(result));
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            Pair pair = result[i];
            if(pair.index != -1) {
                int l = pair.index + 1;
                while (l < n && nums[i] >= nums[l]) l = result[l].index;
                if (l >= n) out[i] = -1;
                else out[i] = nums[i];
            }
        }
        return out;
    }
}
