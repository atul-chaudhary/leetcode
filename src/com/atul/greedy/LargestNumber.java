package com.atul.greedy;

import java.util.Arrays;
import java.util.Map;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    static class Pair{
        int org;
        int formed;

        public Pair(int org, int formed) {
            this.org = org;
            this.formed = formed;
        }
    }
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        int largest = Integer.MIN_VALUE;
        for (int it : nums){
            String s = String.valueOf(it);
            largest = Math.max(largest, s.length());
        }
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            String num = String.valueOf(nums[i]);
            String newNUm = formNumber(largest, num);
            arr[i] = new Pair(Integer.parseInt(num), Integer.parseInt(newNUm));
        }
        Arrays.sort(arr, (a,b)->a.formed==b.formed ? a.org- b.org : b.formed-a.formed);
        StringBuilder sb = new StringBuilder();
        for(Pair it : arr){
            sb.append(it.org);
        }
        return sb.toString();
    }

    private static String formNumber(int largest, String num){
        int len = num.length();
        int diff = largest-len;
        String result = num;
        for (int i = 0; i < diff; i++) {
            result+="0";
        }
        return result;
    }
}
