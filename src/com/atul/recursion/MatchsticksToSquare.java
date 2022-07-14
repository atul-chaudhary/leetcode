package com.atul.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchsticksToSquare {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2};
        System.out.println(makesquare(arr));
    }

    public static boolean makesquare(int[] arr) {
        int total = 0;
        for (int ele : arr) {
            total += ele;
        }
        int side;
        if (total % 4 == 0) {
            side = total / 4;
            System.out.println(side);
            Arrays.sort(arr);
            reverse(arr);
            System.out.println(Arrays.toString(arr));
            return dfs(arr, 0, arr.length, new int[4], side);
        } else {
            return false;
        }
    }

    private static void reverse(int[] arr){
        int i = 0;
        int j = arr.length -1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static boolean dfs(int[] arr, int idx, int size, int[] sides, int cur_side) {
        if (idx == size) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + arr[idx] <= cur_side) {
                sides[i] += arr[idx];
                if (dfs(arr, idx + 1, size, sides, cur_side)) {
                    return true;
                }
                sides[i] -= arr[idx];
            }
        }
        return false;
    }

    class Solution {
        public List<Integer> nums;
        public int[] sums;
        public int possibleSquareSide;

        public Solution() {
            this.sums = new int[4];
        }

        // Depth First Search function.
        public boolean dfs(int index) {

            // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
            if (index == this.nums.size()) {
                return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
            }

            // Get current matchstick.
            int element = this.nums.get(index);

            // Try adding it to each of the 4 sides (if possible)
            for (int i = 0; i < 4; i++) {
                if (this.sums[i] + element <= this.possibleSquareSide) {
                    this.sums[i] += element;
                    if (this.dfs(index + 1)) {
                        return true;
                    }
                    this.sums[i] -= element;
                }
            }

            return false;
        }

        public boolean makesquare(int[] nums) {
            // Empty matchsticks.
            if (nums == null || nums.length == 0) {
                return false;
            }

            // Find the perimeter of the square (if at all possible)
            int L = nums.length;
            int perimeter = 0;
            for (int i = 0; i < L; i++) {
                perimeter += nums[i];
            }

            this.possibleSquareSide = perimeter / 4;
            if (this.possibleSquareSide * 4 != perimeter) {
                return false;
            }

            // Convert the array of primitive int to ArrayList (for sorting).
            this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(this.nums, Collections.reverseOrder());
            return this.dfs(0);
        }
    }
}
