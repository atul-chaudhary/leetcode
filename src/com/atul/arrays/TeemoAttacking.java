package com.atul.arrays;

public class TeemoAttacking {
    public static void main(String[] args) {
        int[] nums = {1, 4};
        int duration = 2;
        System.out.println(findPoisonedDuration(nums, duration));
    }

    public static int findPoisonedDuration(int[] nums, int duration) {
        int n = nums.length;
        int first = 0;
        int last = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int to = num + duration - 1;
            if (num >= first && num <= last) {
                count -= last - first + 1;
                count += to - first + 1;
            } else {
                count += to - num + 1;
            }

            first = num;
            last = to;
        }
        return count;
    }
}
