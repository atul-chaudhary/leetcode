package com.atul.arrays;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        int [] arr = {400};//{17,18,5,4,6,1};
        //System.out.println(Arrays.toString(replaceElements(arr)));
        System.out.println(Arrays.toString(replaceElementsWithoutExtraSpace(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        int largestTillNow = arr[len-1];
        temp[len-1] = -1;
        for (int i=len-2;i>=0;i--){
            temp[i] = largestTillNow;
            if(arr[i] > largestTillNow){
                largestTillNow = arr[i];
            }
        }
        return temp;
    }

    public static int[] replaceElementsWithoutExtraSpace(int[] arr) {
        int len = arr.length;
        int largestTillNow = arr[len-1];
        arr[len-1] = -1;
        for (int i=len-2;i>=0;i--){
            int temp = arr[i];
            arr[i] = largestTillNow;
            if(temp > largestTillNow){
                largestTillNow = temp;
            }
        }
        return arr;
    }
}
