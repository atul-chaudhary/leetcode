package com.atul.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(numberOfPairs(arr)));
    }

    public static int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int it : nums) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }

        int count = 0;
        int left = 0;
        while (true) {
            boolean flag = true;
            for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
                if (ent.getValue() >= 2) {
                    map.put(ent.getKey(), ent.getValue() - 2);
                    count++;
                    flag = false;
                }
            }

            if (flag) break;
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if(ent.getValue() == 1){
                left++;
            }
        }
        return new int[]{count, left};
    }
}
