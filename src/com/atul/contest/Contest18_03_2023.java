package com.atul.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Contest18_03_2023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int vert = Integer.parseInt(br.readLine());
            dist.put(vert, (int) 1e9);
            graph.putIfAbsent(vert, new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int t = Integer.parseInt(split[2]);
            graph.get(u).add(new int[]{v, t});
        }
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
//        System.out.println();
//        System.out.println(graph+"<<>>");
//        System.out.println("a"+a);
//        System.out.println("b"+b);
        Queue<int[]> pq = new PriorityQueue<>((a1, b1) -> a1[1] - b1[1]);
        pq.offer(new int[]{a, 0});
        dist.put(a, 0);
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int vert = node[0];
            int time = node[1];
            for (int[] child : graph.get(vert)) {
                int newTime = time + child[1];
                int oldTime = dist.get(child[0]);
                if (newTime < oldTime) {
                    dist.put(child[0], newTime);
                    pq.offer(new int[]{child[0], newTime});
                }
            }
        }

        int ans = dist.get(b);
        if(ans == (int)1e9){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }


    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = ((nums[i] % value) + value) % value;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        while (true) {
            int rem = ans % value;
            if (map.containsKey(rem)) {
                map.put(rem, map.get(rem) - 1);
                if (map.get(rem) == 0) {
                    map.remove(rem);
                }
            } else {
                return ans;
            }
            ans++;
        }
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
            Map.Entry<Integer, Integer> ceil = map.ceilingEntry(num + 1);
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
