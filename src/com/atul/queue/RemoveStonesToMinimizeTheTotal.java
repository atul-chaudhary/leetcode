package com.atul.queue;

import org.omg.CORBA.ARG_IN;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveStonesToMinimizeTheTotal {
    public static void main(String[] args) {
        int[] piles = {5,4,9};//{4,3,6,7};
        int k = 2;
        System.out.println(minStoneSum(piles, k));
    }

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int minStoneSum(int[] piles, int k) {
        int n = piles.length;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(piles[i], i));
        }
        while (k > 0 && !pq.isEmpty()) {
            Pair pair = pq.poll();
            int index = pair.index;
            int cal = piles[index] - (int)Math.floor(piles[index]*1.0/2);
            //System.out.println(cal+"cal");
            piles[index] = cal;
            pq.offer(new Pair(piles[index], index));
            k--;
        }
        System.out.println(Arrays.toString(piles));
        int sum = 0;
        for(int it : piles){
            sum+=it;
        }

        return sum;
    }
}
