package com.atul.contest;

import java.util.*;

public class Contest23_04_2023 {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(countEven(n));
    }

    public static int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (solve(String.valueOf(i))) {
                count++;
            }
        }
        return count;
    }

    private static boolean solve(String num) {
        int n = num.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        //System.out.println(result + "<<>>");
        return result % 2 == 0;
    }

    public static int getLucky(String s, int k) {
        int n = s.length();
        String num = "";
        for (int i = 0; i < n; i++) {
            num += String.valueOf(s.charAt(i) - 'a' + 1);
        }
        return solve(num, k, 1);
    }

    private static int solve(String num, int k, int cur) {
        if (cur == k) return Integer.parseInt(num);
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            result += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return solve(String.valueOf(result), k, cur + 1);
    }


    class SmallestInfiniteSet {
        TreeSet<Integer> set = new TreeSet<>();

        public SmallestInfiniteSet() {
            for (int i = 1; i <= 100; i++) {
                set.add(i);
            }
        }

        public int popSmallest() {
            return set.pollFirst();
        }

        public void addBack(int num) {
            set.add(num);
        }
    }


    public int minOperations(int[] nums) {
        int n = nums.length;
        int oneCount = 0;
        for (int it : nums) {
            if (it == 1) {
                oneCount++;
            }
        }
        int result = 0;
        if (oneCount > 0) {
            result = n - oneCount;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int gcd = gcd(nums[i], nums[j]);
                    if (gcd == 1) {
                        min = Math.min(min, j - i + n - 1);
                    }
                }
            }
            result = min == Integer.MAX_VALUE ? -1 : min;
        }

        return result;
    }

    private static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int len = n - k + 1;
        int[] result = new int[len];
        int index = 0;
        int count = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            count++;
            int ind = Collections.binarySearch(arr, nums[i]);
            if (ind < 0) {
                ind = -(ind + 1);
            }
            arr.add(ind, nums[i]);
            if (count == k) {
                count--;
                int nms = arr.get(x - 1);
                if (nms < 0)
                    result[index++] = arr.get(x - 1);
                else {
                    result[index++] = 0;
                }
                int del = Collections.binarySearch(arr, nums[i - k + 1]);
                arr.remove(del);
            }
        }
        return result;
    }

    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int num = arrivalTime + delayedTime;
        if (num == 24) {
            return 0;
        } else if (num > 24) {
            return num - 24;
        } else return num;
    }

    public static int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
