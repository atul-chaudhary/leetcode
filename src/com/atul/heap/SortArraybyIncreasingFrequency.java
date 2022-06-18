package com.atul.heap;

import java.util.*;

public class SortArraybyIncreasingFrequency {
    public static void main(String[] args) {
        int[] arr = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(arr)));
    }

    static class Pair{
        Integer val;
        Integer freq;

        public Pair(Integer val, Integer freq){
            this.val = val;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", freq=" + freq +
                    '}';
        }
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        Queue<Pair> pq = new PriorityQueue<>((a, b)->{
            if(a.freq.equals(b.freq)){
                return b.val - a.val;
            }
            return a.freq.compareTo(b.freq);
        });

        map.forEach((key, val)->{
            pq.offer(new Pair(key, val));
        });

        int[] result = new int[nums.length];
        int j=0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i=0;i<p.freq;i++){
                result[j++] = p.val;
            }
        }
        return result;
    }
}
