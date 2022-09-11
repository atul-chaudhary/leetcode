package com.atul.contest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentEvenElement {
    public static void main(String[] args) {
        int[] arr = {29,47,21,41,13,37,25,7};
        System.out.println(mostFrequentEven(arr));
    }

    public static int mostFrequentEven(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        for (int it : nums){
            if(it % 2==0){
                treemap.put(it, treemap.getOrDefault(it, 0)+1);
            }
        }

        int num = -1;
        int freq = -1;
        for(Map.Entry<Integer, Integer> entry : treemap.entrySet()){
            if(entry.getValue() > freq){
                num = Math.max(num, entry.getKey());
                freq = Math.max(freq, entry.getValue());
            }
        }
        return num;
    }
}
