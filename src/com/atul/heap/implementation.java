package com.atul.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class implementation {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        Queue<Integer> process = new PriorityQueue<>(Comparator.reverseOrder());
        int k = 3;
        int count = 0;
        for(int i=0;i< arr.length;i++){
            count++;
            process.offer(arr[i]);
            if(count > k){
                process.poll();
                count--;
            }
        }
        System.out.println(process.peek());
    }
}
