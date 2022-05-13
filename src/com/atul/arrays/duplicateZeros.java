package com.atul.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode 1089
public class duplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
    }
    public static void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if(arr[i]==0){
                queue.add(0);
            }
            arr[i] = queue.remove();
        }
        //System.out.println(Arrays.toString(arr));
    }
}
