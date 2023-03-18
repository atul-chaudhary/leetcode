package com.atul.contest;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Contest18_03_2023 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,1,3,1};
        System.out.println(maximizeGreatness(nums));
        //System.out.println(findScore(nums));
    }


    public static long findScore(int[] nums) {
        int n = nums.length;
        boolean[] mark = new boolean[n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        long num = 0;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (mark[node[1]]) {
                continue;
            }
            num += node[0];
            if (node[1] - 1 >= 0) {
                mark[node[1] - 1] = true;
            }

            if (node[1] + 1 < n) {
                mark[node[1] + 1] = true;
            }
        }
        return num;
    }

    public static int maximizeGreatness(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(num+1);
            if (ceil != null) {
                count++;
                map.put(ceil.getKey(), ceil.getValue() - 1);
                if (map.get(ceil.getKey()) == 0) {
                    map.remove(ceil.getKey());
                }
            }
        }

        return count;
    }

}
