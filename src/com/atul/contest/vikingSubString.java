package com.atul.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class vikingSubString {
    public static void main(String[] args) {
        int[] ch = {10,10};
        System.out.println(solve(ch));
    }

    public static int solve(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int temp = 1;
        int cur = 0;
        for(int i=0;i< arr.length;i++){
            cur++;
            if(cur == temp){
                count++;
                temp++;
                cur =0;
            }
        }
        return count;
    }
}
