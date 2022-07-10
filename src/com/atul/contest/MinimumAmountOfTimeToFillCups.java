package com.atul.contest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumAmountOfTimeToFillCups {
    public static void main(String[] args) {
        int[] arr = {5, 4, 4};
        System.out.println(fillCups(arr));
    }

    public static int fillCups(int[] arr) {
        Queue<Integer> process = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : arr) {
            if (i > 0) {
                process.add(i);
            }
        }
        int count = 0;
        while (process.size() >= 2) {
            int a = process.poll();
            int b = process.poll();
            count++;
            if (a != 1) {
                process.add(--a);
            }
            if (b != 1)
                process.add(--b);
        }
        int yo = process.peek();
        return count + yo;
    }
}
