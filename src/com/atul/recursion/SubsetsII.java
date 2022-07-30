package com.atul.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0);
        System.out.println(res);

        List<List<Integer>> result = new ArrayList<>();
        subSet(nums, 0, new ArrayList<>(), result);
        System.out.println(result);

    }

    private static void subSet(int[] nums, int index, List<Integer> ds, List<List<Integer>> result){
        result.add(new ArrayList<>(ds));

        for(int i= index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            ds.add(nums[i]);
            subSet(nums, i+1, ds, result);
            ds.remove(ds.size() -1);
        }
    }

    public  static void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos) {
        res.add(new ArrayList<>(ls));
        for(int i=pos;i<nums.length;i++) {
            if(i>pos&&nums[i]==nums[i-1]) continue;
            ls.add(nums[i]);
            helper(res,ls,nums,i+1);
            ls.remove(ls.size()-1);
        }
    }

}
