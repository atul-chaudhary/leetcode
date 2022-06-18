package com.atul.heap;

import sun.security.x509.AlgIdDSA;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortAKSortedArray {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        Queue<Integer> process = new PriorityQueue<>();
        int k = 3;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            process.offer(arr[i]);
            if(process.size() > k){
                list.add(process.poll());
            }
        }

        while(!process.isEmpty()){
            list.add(process.poll());
        }

        System.out.println(list);
    }
}
