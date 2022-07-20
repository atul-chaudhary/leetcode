package com.atul.contest;

import java.util.PriorityQueue;

public class MinimumDeletionsToMakeArrayDivisible {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 4, 3};
        int[] numsDivide = {9, 6, 9, 3, 15};
        System.out.println(minOperationsOpt(nums, numsDivide));
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.offer(it);
        }

        int count = 0;
        while (!pq.isEmpty()) {
            int ele = pq.poll();
            boolean isAllDivided = false;
            if (numsDivide[0] % ele == 0) {
                boolean isDiv = true;
                for (int i = 0; i < numsDivide.length; i++) {
                    if (numsDivide[i] % ele != 0) {
                        isDiv = false;
                    }
                }
                isAllDivided = isDiv;
            }
            count++;
            if (isAllDivided) return count - 1;
        }
        return -1;
    }

    public static int minOperationsOpt(int[] nums, int[] numsDivide) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.offer(it);
        }
        int count = 0;
        int gcd = findGCD(numsDivide);
        while (!pq.isEmpty()) {
            int ele = pq.poll();
            count++;
            if(gcd % ele == 0){
                return count-1;
            }
        }
        return -1;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int findGCD(int[] arr) {
        int result = arr[0];
        for (int element : arr) {
            result = gcd(result, element);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }
}
