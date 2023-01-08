package com.atul.contest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Contest07012023 {
    public static void main(String[] args) {
        int[] nums = {15, 45, 20, 2, 34, 35, 5, 44, 32, 30};
        System.out.println(xorBeauty(nums));
    }

    public static int xorBeauty(int[] nums) {
        int num = 0;
        for(int it : nums){
            num^=it;
        }
        return num;
    }

    static class DataStream {
        int val;
        int k;
        int count = 0;
        Queue<Integer> pq = new LinkedList<>();

        public DataStream(int value, int k) {
            this.val = value;
            this.k = k;
        }

        public boolean consec(int num) {
            pq.offer(num);
            if (num == val) count++;
            if (pq.size() < k) {
                return false;
            } else if (pq.size() == k) {
                if (count == k) return true;
                return false;
            } else {
                int number = pq.poll();
                if (number == val) {
                    count--;
                }
                if (count == k) {
                    return true;
                }
                return false;
            }
        }
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        long vol = ((long) length * width) * height;
        boolean bulky = false;
        boolean heavy = false;

        if (length >= 10000 || width >= 10000 || height >= 10000 || vol >= (int) 1e9) {
            bulky = true;
        }
        if (mass >= 100) {
            heavy = true;
        }

        if (bulky && heavy) {
            return "Both";
        }
        if (!bulky && !heavy) {
            return "Neither";
        }

        if (bulky && !heavy) {
            return "Bulky";
        }
        if (heavy && !bulky) {
            return "Heavy";
        }
        return null;
    }
}
