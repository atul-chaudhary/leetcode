package com.atul.arrays;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] arr = {-2,-1,1,2,2147483646,2147483647};
        System.out.println(summaryRanges(arr));
    }
    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int lastNum = Integer.MIN_VALUE;
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < n) {
            lastNum = nums[index];
            int curNum = Integer.MIN_VALUE;
            while (index + 1 < n && nums[index] + 1 == nums[index+1]){
                index++;
                curNum = nums[index];
            }

            if(curNum != Integer.MIN_VALUE){
                result.add(lastNum+"->"+curNum);
            }else result.add(String.valueOf(lastNum));
            index++;
        }
        return result;
    }

}
