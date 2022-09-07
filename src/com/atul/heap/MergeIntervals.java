package com.atul.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        //System.out.println(Arrays.toString(merge(arr)));
        int[][] result = merge(arr);
        for (int[] row : result) System.out.println(Arrays.toString(row));
    }


    public static int[][] merge(int[][] arr) {
        class Pair {
            Integer start;
            Integer end;

            Pair(Integer start, Integer end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.end.compareTo(a.end));
        pq.add(new Pair(arr[0][0], arr[0][1]));
        for (int i = 1; i < arr.length; i++) {
            Pair p = pq.peek();
            if (p.start <= arr[i][0] && arr[i][0] <= p.end) {
                pq.poll();
                pq.add(new Pair(p.start, p.end > arr[i][1] ? p.end : arr[i][1]));
            } else {
                pq.add(new Pair(arr[i][0], arr[i][1]));
            }
        }
        int[][] result = new int[pq.size()][2];
        int n = pq.size();
        for (int i = 0; i < n ; i++) {
            Pair p = pq.poll();
            result[i][0] = p.start;
            result[i][1] = p.end;
        }
        Arrays.sort(result, (a, b)->a[0]-b[0]);
        return result;
    }
}
