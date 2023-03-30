package com.atul.greedy;

import java.util.*;

public class PrimeSubtractionOperation {
    public static void main(String[] args) {
        int[] nums = {998,2};
        System.out.println(primeSubOperation(nums));
    }

    public static boolean primeSubOperation(int[] nums) {
        TreeSet<Integer> primes = new TreeSet<>();
        primes.add(0);
        for (int j = 2; j <= 1000; j++) {
            if (prime(j)) {
                primes.add(j);
            }
        }

        int n = nums.length;
        int prev = 0;
        for (int j = 0; j < n; j++) {
            int cur = nums[j];
            int diff = nums[j] - prev - 1;
            if (diff > 0)
                nums[j] -= primes.floor(diff);
            prev = nums[j];
        }

        for (int j = 1; j < n; j++) {
            if (nums[j] <= nums[j - 1]) {
                return false;
            }
        }
        return true;
    }

    static boolean prime(int no) {
        int count = 0;
        for (int i = 1; i <= no; i++) {
            if (no % i == 0)
                count++;
        }
        if (count == 2)
            return true;
        else
            return false;
    }

}
