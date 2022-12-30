package com.atul.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SingleThreadedCPU {

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.toString(getOrder(nums)));
    }

    static class Pair {
        int index;
        int start;
        int time;

        public Pair(int index, int start, int time) {
            this.index = index;
            this.start = start;
            this.time = time;
        }
    }

    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] extTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            extTasks[i][0] = i;
            extTasks[i][1] = tasks[i][0];
            extTasks[i][2] = tasks[i][1];
        }
        Arrays.sort(extTasks, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time = 0;
        int ansIndex = 0;
        int taskIndex = 0;
        while (ansIndex < n) {
            while (taskIndex < n && extTasks[taskIndex][1] <= time) {
                pq.offer(extTasks[taskIndex++]);
            }
            if (pq.isEmpty()) {
                time = extTasks[taskIndex][1];
                continue;
            }
            int[] bestFit = pq.poll();
            ans[ansIndex++] = bestFit[0];
            time += bestFit[2];
        }
        return ans;
    }

    public static int[] getOrderopt(int[][] tasks) {
        int n = tasks.length;
        Pair[] nums = new Pair[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(nums, (a, b) -> a.start == b.start ? a.index - b.index : a.start - b.start);
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.start == b.start ? a.index - b.index : a.start - b.start);
        int index = 0;
        int[] result = new int[n];
        pq.offer(nums[index]);
        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            ;
            int start = it.start;
            int end = it.time;
            int newIndex = it.index;
            result[index++] = newIndex;
            int count = 0;
            for (int i = start; i <= start + end; i++) {
            }
        }
        return result;
    }
}
