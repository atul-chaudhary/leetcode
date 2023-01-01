package com.atul.arrays;

import java.util.*;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] edges = {4,1,2,3};
        System.out.println(Arrays.toString(sortEvenOdd(edges)));
    }

    public static  int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                even.add(nums[i]);
            }else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        int evenIndex = 0;
        int oddIndex = 0;
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                nums[i] = even.get(evenIndex++);
            }else {
                nums[i] = odd.get(oddIndex++);
            }
        }
        return nums;
    }

    //[28,-41,22,-8,46,-37,35,-9,18,-6,19,-26,15,-10,14,-37,31,-9] my output
    //[28,-41,22,-8,46,-37,35,-9,18,-6,19,-26,15,-37,14,-10,31,-9] correct output
    //[28, -41, 22, -8, 46, -37, 35, -9, 18, -6, 19, -26, 15, -37, 14, -10, 31, -9]

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result  = new int[n];
        int post= 0;
        int neg = 1;
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0){
                result[post] = nums[i];
                post+=2;
            }else {
                result[neg] = nums[i];
                neg+=2;
            }
        }
        return result;
    }

    public static int[] rearrangeArrayOpt(int[] nums) {
        int n = nums.length;
        Queue<Integer> pq = new LinkedList<>();
        for (int it : nums) {
            pq.add(it);
        }
        int positive = 0;
        int negative = 1;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (num > 0) {
                nums[positive] = num;
                positive += 2;
            } else {
                nums[negative] = num;
                negative += 2;
            }
        }
        return nums;
    }

}
