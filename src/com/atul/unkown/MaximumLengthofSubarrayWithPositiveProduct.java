package com.atul.unkown;

public class MaximumLengthofSubarrayWithPositiveProduct {


    public static void main(String[] args) {
        int[] arr = {2, -5, -2, -4, 3};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int maxP=1;//nums[0];  //Stores the maximum product soo far
        int minP=1;  //Stores the minimum product soo far basically the -ve product
        int ans=nums[0];   //Stores the answer to be returned

        for(int i=0;i<nums.length;i++){
            int first=nums[i];         //First Possibility
            int second=maxP*nums[i];   //Second Possibility
            int third=minP*nums[i];    //Third Possibility
            minP=Math.min( Math.min(first,second) ,third);
            maxP=Math.max( Math.max(first,second) ,third);
            ans=Math.max(ans,maxP);

        }
        return ans;
    }

    public static int maxProductBrute(int[] nums) {
        int result = 0;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int start = i;
            int end = i;
            while (start < n && nums[start] == 0) start++;
            int num = 1;
            int temp = 1;
            while (end < n && nums[end] != 0) {
                num *= nums[end];
                temp = Math.max(nums[end], num);
                result = Math.max(result, temp);
                end++;
                System.out.println(result + "<<>>" + " " + num);
            }
            i = end + 1;
        }
        return result;
    }

    public static int getMaxLenOpt(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ) {
            int start = i;
            while (start < n && nums[start] == 0) {
                start++;
            }
            int neg = 0;
            int end = start;
            int startNeg = -1;
            int endNeg = -1;
            while (end < n && nums[end] != 0) {
                if (nums[end] < 0) {
                    neg++;
                    if (startNeg == -1) startNeg = end;
                    endNeg = end;
                }
                end++;
            }
            if (neg % 2 == 0) {
                ans = Math.max(ans, end - start);
            } else {
                if (startNeg != -1) ans = Math.max(ans, end - startNeg - 1);
                if (endNeg != -1) ans = Math.max(ans, endNeg - start);
            }
            i = end + 1;
        }
        return ans;
    }

    private static int cal(int firstNeg, int lastNeg, int n, int start) {
        int left = 0;
        if (firstNeg != -1) {
            left = firstNeg - start;
        }
        int right = 0;
        if (lastNeg != -1) {
            right = n - lastNeg;
        }
        if (left < right) {
            return (n - start) - left;
        } else {
            return (n - start) - right;
        }
    }

    public static int getMaxLen(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int count = 0;
                int neg = 0;
                for (int j = i; j < n; j++) {
                    if (nums[j] != 0) {
                        count++;
                        if (nums[j] < 0) {
                            neg++;
                        }
                        if (neg % 2 == 0) {
                            max = Math.max(max, count);
                        }
                    } else break;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
