package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] nums = {2,3};//{4,2,5,7};//{2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int left = 0;
        while (left < n) {
            while (left < n && ((left % 2 == 0 && nums[left] % 2 == 0) || (left % 2 != 0 && nums[left] % 2 != 0))) {
                left++;
            }
            if(left >= n-1) break;
            int right = left + 1;
            if (nums[left] % 2 == 0) {
                while (right < n && nums[right]%2==0) right++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }else {
                while (right < n && nums[right]%2!=0) right++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
        }
        return nums;
    }

    public static int[] sortArrayByParityIIOpt(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int it : nums) {
            stack.push(it);
        }
        int even = 0;
        int odd = 1;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num % 2 == 0) {
                nums[even] = num;
                even += 2;
            } else {
                nums[odd] = num;
                odd += 2;
            }
        }
        return nums;
    }
}
