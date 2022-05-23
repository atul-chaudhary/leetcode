package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int[][] arrr = {{1,2},{3,4},{5,6}};
        ArrayList<ArrayList<Integer>> ara = new ArrayList<>();
        ArrayList ar1 = new ArrayList();
        ar1.add(1);
        ar1.add(2);
        ArrayList ar2 = new ArrayList();
        ar1.add(2);
        ar1.add(3);
        ArrayList ar3 = new ArrayList();
        ar1.add(4);
        ar1.add(5);

        ara.add(ar1);
        ara.add(ar2);
        ara.add(ar3);
        List<Integer> list = ara.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(list);
        //System.out.println(minlen);
        /*System.out.println(list);
        int maxLen = Integer.MAX_VALUE;
        int target = 7;
        int first = -1;
        int sec = -1;
        for (int i = 0; i < list.size(); i++) {
            int cur_sum = 0;
            int cur_min_len = 0;
            for (int j = 0; j < list.get(i).size(); j++) {
                cur_sum+=list.get(i).get(j);
                cur_min_len++;
                if(cur_sum >= target && cur_min_len < maxLen){
                    System.out.println(i+" "+j);
                    maxLen = cur_min_len;
                    first = i;
                    sec = j;
                    break;
                }
            }
        }
        System.out.println(
                list.get(first)
        );*/
    }

    public static List<Integer> subArray(int first, int last, int[] arr){
        List<Integer> list = new ArrayList<>();
        for (int i = first; i <= last; i++) {
         list.add(arr[i]);
        }
        return list;
    }
}
