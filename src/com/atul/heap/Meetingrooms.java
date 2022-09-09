package com.atul.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Meetingrooms {
    public static void main(String[] args) {
        int[][] dp = {
                {1, 18},
                {18, 23},
                {15, 29},
                {4, 15},
                {2, 11},
                {5, 13},
        };

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] row : dp) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(row[0]);
            temp.add(row[1]);
            result.add(temp);
        }

        System.out.println(solve(result));
    }

    public static int solve(ArrayList<ArrayList<Integer>> arr) {
        Collections.sort(arr, (a, b) -> a.get(0) - b.get(0));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr.get(0).get(1));
        int count = 1;
        for (int i = 1; i < arr.size(); i++) {
            int num = pq.peek();
            if (arr.get(i).get(0) >= num) {
                pq.poll();
                pq.add(arr.get(i).get(1));
            } else {
                pq.add(arr.get(i).get(1));
                count++;
            }
        }
        return count;
    }
}
