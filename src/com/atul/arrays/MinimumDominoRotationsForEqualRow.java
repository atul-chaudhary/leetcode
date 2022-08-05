package com.atul.arrays;

import javax.print.DocFlavor;

public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        int[] tops = {3,5,1,2,3};
        int[] bottom = {3,6,3,3,4};
        System.out.println(minDominoRotations(tops, bottom));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int[] dice1 = new int[6];
        int max1 = Integer.MIN_VALUE;
        int index1 = -1;
        for(int i=0;i<tops.length;i++){
            dice1[tops[i]-1]++;
            if(dice1[tops[i]-1] > max1){
                max1 = dice1[tops[i]-1];
                index1 = i;
            }
        }
        System.out.println(index1+ " <<>> "+max1);
        int[] dice2 = new int[6];
        int index2 = -1;
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<bottoms.length;i++){
            dice2[bottoms[i]-1]++;
            if(dice2[bottoms[i]-1] > max2){
                max2 = dice2[bottoms[i]-1];
                index2 = i;
            }
        }

        System.out.println(index2+ " <<>> "+max2);
        return 0;
    }
}
