package com.atul.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumRoundsToCompleteAllTasks {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(nums));
    }

    static class Pair {
        int val;
        int fre;

        public Pair(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }
    }

    public static int minimumRounds(int[] tasks) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : tasks) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getValue();
            if (num < 2) {
                return -1;
            }
            while(num > 3){
                num-=3;
               count++;
            }
            count++;
        }
        return count;
    }


    public static int minimumRoundsopt(int[] tasks) {
        int n = tasks.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : tasks) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        int m = map.size();
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if (ent.getValue() < 2) return -1;
            pq.offer(new Pair(ent.getKey(), ent.getValue()));
        }
        int count = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (pair.fre > 3) {
                pair.fre -= 3;
                pq.offer(pair);
            }
            count++;
        }
        return count;
    }
}
