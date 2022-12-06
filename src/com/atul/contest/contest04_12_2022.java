package com.atul.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class contest04_12_2022 {
    public static void main(String[] args) {
//        String s = "Leetcode is cool";//"eetcode";//"leetcode exercises sound delightful";
//        System.out.println(isCircularSentence(s));
///[2,1,5,2]
        int[] arr = {2, 1, 5, 2};
        System.out.println(dividePlayers(arr));
    }

    class Pair {
        int destNode;
        int weight;

        public Pair(int destNode, int weight) {
            super();
            this.destNode = destNode;
            this.weight = weight;
        }

    }

    public int minScore(int n, int[][] roads) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<Pair>());

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.weight - b.weight);
        for (int[] a : roads) {
            adj.get(a[0]).add(new Pair(a[1], a[2]));
            adj.get(a[1]).add(new Pair(a[0], a[2]));
        }
        pq.add(new Pair(1, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (Pair tmp : adj.get(p.destNode)) {
                if (dist[tmp.destNode] > Math.min(p.weight, tmp.weight)) {
                    dist[tmp.destNode] = Math.min(p.weight, tmp.weight);
                    pq.add(new Pair(tmp.destNode, dist[tmp.destNode]));
                }
            }
        }
        return dist[n];
    }

    public static long dividePlayers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int it : nums) sum += it;
        int teamSize = n / 2;
        if (sum % teamSize != 0) return -1;
        int pairSize = sum / teamSize;
        long ans = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] + nums[right] != pairSize) return -1;
            long temp = (long) nums[left] * nums[right];
            ans += temp;
            left++;
            right--;
        }
        return ans;
    }

    public static boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                if (arr[0].charAt(0) != arr[n - 1].charAt(arr[n - 1].length() - 1)) {
                    return false;
                }
            } else {
                if (i + 1 < n && arr[i].charAt(arr[i].length() - 1) != arr[i + 1].charAt(0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
