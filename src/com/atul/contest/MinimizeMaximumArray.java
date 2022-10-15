package com.atul.contest;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinimizeMaximumArray {
    public static void main(String[] args) {
        int[] nums = {3,7,1,6};
        System.out.println(minimizeArrayValue(nums));
    }

    static class Pair{
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }
    public static int minimizeArrayValue(int[] nums) {
        return 0;
    }
}
