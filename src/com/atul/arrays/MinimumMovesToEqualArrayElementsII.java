package com.atul.arrays;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        /*Arrays.sort(sort, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });*/
        System.out.println(minMoves2(nums));
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length/2);
        System.out.println(mid);
        int mele = nums[mid];
        System.out.println(mele);
        int moves = 0;
        for(int it : nums){
            moves += Math.abs(mele-it);
        }

        return moves;
    }
}
