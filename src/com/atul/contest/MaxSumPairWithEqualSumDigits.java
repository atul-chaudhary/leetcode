package com.atul.contest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSumPairWithEqualSumDigits {
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        System.out.println(maximumSumOpt(nums));
    }

    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j =0;j< nums.length;j++){
            String s = String.valueOf(nums[j]);
            int sum = 0;
            for(int i=0;i<s.length();i++){
                sum+= Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            map.put(j, sum);
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i != j && map.get(i).equals(map.get(j))){
                    max = Math.max(max,nums[i]+nums[j]);
                }
            }
        }
        return max;
    }

    public static int maximumSumOpt(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int it: nums){
            int sum = 0;
            String s = String.valueOf(it);
            for(int i=0;i<s.length();i++) sum+=Integer.parseInt(String.valueOf(s.charAt(i)));
            if(map.containsKey(sum)){
                PriorityQueue<Integer> pr = map.get(sum);
                pr.add(it);
                map.put(sum, pr);
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                pq.add(it);
                map.put(sum, pq);
            }
        }
        int max = -1;
        for(Map.Entry<Integer, PriorityQueue<Integer>> ent : map.entrySet()){
            if(ent.getValue().size() >=2){
                int one = ent.getValue().poll();
                int two = ent.getValue().poll();
                max = Math.max(max, one+two);
            }
        }
        return max;
    }
}
