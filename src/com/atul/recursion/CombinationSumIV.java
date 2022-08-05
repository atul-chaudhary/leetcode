package com.atul.recursion;

import java.util.ArrayList;

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solve(0, nums, target, result, new ArrayList<>());
        System.out.println(result);
    }

    int count = 0;
    private void solve(int[] nums, int target){
        if(target == 0){
            count++;
        }

        for(int i=0;i< nums.length;i++){
            solve(nums, target-nums[i]);
        }
    }

    private static int solve(int index, int[] nums, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ds){

        if(index == nums.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
                return 1;
            }
            return 0;
        }
        int left = 0;
        if(nums[index] <= target){
            ds.add(nums[index]);
            left = solve(index, nums, target - nums[index], result, ds);
            ds.remove(ds.size()-1);
        }
        int notPick = solve(index +1, nums, target, result, ds);
        return left+notPick;
    }
}
