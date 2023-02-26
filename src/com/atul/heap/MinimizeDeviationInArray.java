package com.atul.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinimizeDeviationInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,10,5,7};
        System.out.println(canBeIncreasingOpt(nums));
    }

    public static boolean canBeIncreasingOpt(int[] nums) {
        int count=0;
        int p=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] || nums[i]==nums[i+1]) {
                count++;
                p=i;
            }
        }
        System.out.println("p"+p);
        if(count>1) return false;
        else if(count==1){
            if(p==0 || p== nums.length-2) return true;
            if(nums[p+1]>nums[p-1] || nums[p+2]>nums[p]) return true;
            else return false;
        }
        return true;
    }

    public static boolean canBeIncreasingBrute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Integer arr = null;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr == null) {
                    arr = nums[j];
                } else {
                    if (nums[j] <= arr) {
                        flag = false;
                        break;
                    }
                    arr = nums[j];
                }
            }
            if (flag) return true;
        }
        return false;
    }

    public static boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek() < nums[i]) {
                stack.push(nums[i]);
            } else {
                while (!stack.isEmpty()) {
                    stack.pop();
                    count++;
                    if (!stack.isEmpty() && stack.peek() < nums[i]) {
                        break;
                    }
                }
                stack.push(nums[i]);
            }
        }
        if (count <= 1) return true;

        return false;
    }

    public static int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : nums) {
            int num = it;
            if (it % 2 != 0) {
                pq.offer(it * 2);
                num = it * 2;
            } else {
                pq.offer(it);
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int ans = max - min;
        while (pq.peek() % 2 == 0) {
            int top = pq.poll();
            ans = Math.min(ans, top - min);
            top /= 2;
            min = Math.min(min, top);
            pq.offer(top);
        }
        ans = Math.min(ans, pq.peek() - min);
        return ans;
    }
}