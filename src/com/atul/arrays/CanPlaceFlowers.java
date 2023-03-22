package com.atul.arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(nums, 2));
    }

    public static boolean canPlaceFlowers(int[] nums, int n) {
        if (n == 0) return true;
        int len = nums.length;
        int index = 0;
        while (index < len) {
            if (nums[index] == 1) {
                index++;
            } else {
                if (index == 0) {
                    if (index + 1 < len && nums[index + 1] != 1) {
                        nums[index] = 1;
                        n--;
                    }
                } else if (index == len - 1) {
                    if (nums[index - 1] != 1) {
                        nums[index] = 1;
                        n--;
                    }
                } else {
                    if (index + 1 < len) {
                        if (nums[index - 1] != 1 && nums[index + 1] != 1) {
                            nums[index] = 1;
                            n--;
                        }
                    }
                }
                index++;
            }
        }

        if (n <= 0) {
            return true;
        }
        return false;
    }
}


