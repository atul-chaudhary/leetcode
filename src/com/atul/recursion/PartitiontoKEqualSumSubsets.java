package com.atul.recursion;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PartitiontoKEqualSumSubsets {
    public static void main(String[] args) {
        int[] arr = {18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037};//{4,3,2,3,5,2,1};
        int k = 4;

        int sum = 0;
        for(int num : arr) sum += num;

        System.out.println(backtrackingOptimised(arr, new boolean[arr.length], k, sum / k, 0));
    }

    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sumOfArrayItems = IntStream.of(nums).sum();

            if(k == 0 || sumOfArrayItems % k != 0){
                return false;
            }
            return canPartition(0, nums, new boolean[nums.length], k, 0, sumOfArrayItems/k);
        }

        public boolean canPartition(int iterationStart, int[] nums, boolean[] used, int k, int inProgressBucketSum, int targetBucketSum){
            if(k == 0){
                return true;
            }

            if(inProgressBucketSum == targetBucketSum){
                return canPartition(0, nums, used, k-1, 0, targetBucketSum);
            }

            for(int i=iterationStart; i<nums.length;i++){
                if(!used[i]){
                    used[i] = true;
                    if(canPartition(i+1, nums, used, k, inProgressBucketSum + nums[i], targetBucketSum)){
                        return true;
                    }
                    used[i] = false;
                }
            }
            return false;
        }
    }

    private static boolean backtrackingOptimised(int[] nums, boolean[] vis, int k, int target, int cur_num){
        if(k == 1){
            return true;
        }

        if(cur_num == target){
            return  backtrackingOptimised(nums, vis, k -1, target, 0);
        }

        for(int j=0;j<nums.length;j++){

            if(vis[j] || cur_num + nums[j] > target) continue;
            vis[j] = true;
            if(backtrackingOptimised(nums, vis, k, target, cur_num + nums[j])){
                return true;
            }
            vis[j] = false;
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length < k) return false;

        int sum = 0;
        for(int num : nums) sum += num;

        if(sum % k != 0) return false;

        Arrays.sort(nums);
        reverse(nums);
        System.out.println(Arrays.toString(nums));
        return dfs(nums, new int[k], 0, sum/k);
    }

    private static boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            for(int j=0;j< sums.length;j++){
                if(sums[j] != target){
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }

        return false;
    }

    private static void reverse(int [] nums){
        int i=0;
        int j =nums.length -1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
