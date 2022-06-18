package com.atul.heap;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr  = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
    }
    static class Pair{
        Integer val;
        Integer key;
        public Pair(Integer val, Integer key){
            this.val = val;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", key=" + key +
                    '}';
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        Queue<Pair> pq = new PriorityQueue<Pair>((a, b)-> b.key.compareTo(a.key));
        map.forEach((key, val)->{
            pq.offer(new Pair(key, val));
        });

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = pq.poll().val;
        }
        return result;
    }
}
