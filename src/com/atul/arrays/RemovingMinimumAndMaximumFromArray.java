package com.atul.arrays;

import java.util.HashMap;
import java.util.Set;
class Messager implements Runnable{
    private String name;

    public Messager(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        message(1);
        message(2);
    }
    private synchronized void message(int n){
        System.out.println(name+ "-"+n+" ");
    }

    public static void main(String[] args) {
        new Thread(new Messager("wallace")).start();
        new Thread(new Messager("gommit")).start();
    }
}

public class RemovingMinimumAndMaximumFromArray implements Runnable {
    public static void main(String[] args) {

    }

    private static void solve(){
        throw new Error();
    }

    public static int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(max < nums[i]){
                max = nums[i];
                maxIndex = i;
            }

            if(min > nums[i]){
                min = nums[i];
                minIndex = i;
            }
        }
        //System.out.println(minIndex  + " "+maxIndex);
        int min1 = Integer.MAX_VALUE;
        int min2 =  Integer.MAX_VALUE;
        if(minIndex > maxIndex){
            int first = (maxIndex+1) + n - minIndex;
            int second = minIndex+1;
            int third = n-maxIndex;
            min1 = Math.min(first, Math.min(second, third));
        }else{
            int first = (minIndex+1) + n - maxIndex;
            int second = maxIndex+1;
            int third = n-minIndex;
            //System.out.println(first+ " "+second+ " "+third);
            min2 = Math.min(first, Math.min(second, third));
        }

        return Math.min(min1, min2);
    }

    @Override
    public void run() {

    }
}
