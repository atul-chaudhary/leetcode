package com.atul.greedy;

import java.util.*;

public class ReduceArraySizeTheHalf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.add(entry.getValue());
        }
        System.out.println(pq);
        int n = arr.length / 2;
        int count = 0;
        while(n>0){
            if(pq.peek() >= n){
                ++count;
                break;
            }else {
                count++;
                n -= pq.poll();
            }
        }
        return count;
    }

    public int minSetSizeUn(int[] arr) {
        class Pair{
            Integer key;
            Integer value;
            Pair(Integer key, Integer value){
                this.key = key;
                this.value = value;
            }
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->b.key.compareTo(a.key));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.add(new Pair(entry.getValue(), entry.getKey()));
        }
        //System.out.println(pq);
        int n = arr.length / 2;
        int count = 0;
        while(!pq.isEmpty()){
            if(pq.peek().key >= n){
                return ++count;
            }else {
                count++;
                n -= pq.poll().key;
            }
        }
        return count;
    }
}
