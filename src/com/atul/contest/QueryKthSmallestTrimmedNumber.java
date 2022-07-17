package com.atul.contest;

import netscape.security.UserTarget;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class QueryKthSmallestTrimmedNumber {
    public static void main(String[] args) {
        String[] nums = {"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"};
        int[][]dp = {{9,4},{6,1},{3,8},{12,9},{11,4},{4,9},{2,7},{10,3},{13,1},{13,1},{6,1},{5,10}};
        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums, dp)));
    }
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] que) {
         class Pair{
            String num;
            Integer index;

            public Pair(String num, Integer index) {
                this.num = num;
                this.index = index;
            }

             @Override
             public String toString() {
                 return "num=" + num + " index=" + index;
             }
         }
        int[] result = new int[que.length];
        for(int i=0;i<que.length;i++){
            if (i==1) {
                int k = que[i][0];
                int t = que[i][1];
                PriorityQueue<Pair> process = new PriorityQueue<>((o1, o2) -> {
                    if(Objects.equals(o1.num, o2.num)){
                        return o1.index.compareTo(o2.index);
                    }else{
                        return o1.num.compareTo(o2.num);
                    }
                });
                for (int j = 0; j < nums.length; j++) {
                    int slen = nums[j].length();
                    String n = nums[j].substring(slen - t, slen);
                    process.offer(new Pair(n, j));
                }
                System.out.println(process);
                for (int j = 0; j < k; j++) {
                    if (!process.isEmpty()) {
                        result[i] = process.poll().index;
                    }
                }
            }
        }
        return result;
    }
}
