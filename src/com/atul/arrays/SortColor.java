package com.atul.arrays;

import java.util.Arrays;

///we have to sort the array of 0's ,1's and 2's
public class SortColor {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        int[] result = sortColor(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortColor(int[] arr) {
        int[] color = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                color[0] +=1;
            else if(arr[i]==1)
                color[1] +=1;
            else color[2] +=1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (color[0] != 0){
                arr[i] = 0;
                color[0] -=1;
            }else if(color[1] != 0){
                arr[i] = 1;
                color[1] -=1;
            }else {
                arr[i] = 2;
                color[2] -= 1;
            }
        }
        return arr;
    }
}
