package com.atul.queue;

import java.util.*;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        if (n < 2) return new ArrayList<>();
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(arr[i] - arr[i - 1], min);
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == min) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }

    public static int minimumCost(int[] cost) {
        int n = cost.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int it : cost) {
            pq.offer(it);
        }
        System.out.println(pq);
        int sum = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            sum += first;
            int second = Integer.MAX_VALUE;
            if (!pq.isEmpty()) {
                second = pq.poll();
                sum += second;
            }
            int min = Math.min(first, second);
            if (!pq.isEmpty() && second != Integer.MAX_VALUE && pq.peek() <= min) {
                pq.poll();
            }
        }
        return sum;
    }
}
