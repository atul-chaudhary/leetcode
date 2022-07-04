package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static void main(String[] args) {
        System.out.println(maxArea(5,4, new int[] {3,1}, new int[]{1}));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hlen = horizontalCuts.length;
        int clen = verticalCuts.length;
        int maxH = 0;
        for(int i=0;i<=hlen;i++){
            int res = 0;
            if(i==0){
                res= horizontalCuts[i];
            }else if(i == hlen){
                res = Math.abs(horizontalCuts[i-1] - h);
            }else{
                res = Math.abs(horizontalCuts[i] - horizontalCuts[i-1]);
            }
            maxH = Math.max(maxH, res);
        }
        int maxV = 0;
        for(int i=0;i<=clen;i++){
            int res = 0;
            if(i==0){
                res = verticalCuts[i];
            }else if(i == clen){
                res = Math.abs(verticalCuts[i-1] - w);
            }else{
                res = Math.abs(verticalCuts[i] - verticalCuts[i-1]);
            }
            maxV = Math.max(maxV, res);
        }
        long ans = (long) maxH * (long) maxV;
        return (int) (ans % 1000000007);
    }
}
