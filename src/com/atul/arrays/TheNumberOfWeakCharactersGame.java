package com.atul.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheNumberOfWeakCharactersGame {
    public static void main(String[] args) {
        int[][] arr = {{2,2},{3,3}};
        System.out.println(numberOfWeakCharacters(arr));
    }

    public static int numberOfWeakCharacters(int[][] arr) {
        Arrays.sort(arr, (a, b) -> (b[0]+b[1])-(a[0]+a[1]));
        //for(int[] row : arr) System.out.println(Arrays.toString(row));
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] row = arr[i];
            System.out.println(Arrays.toString(row));
            int last = n-1;
            while(last > i){
                if(arr[last][1]>row[1] && arr[last][0] > row[0]){
                    System.out.println("inside als");
                    count++;
                    break;
                }
                last--;
            }
        }
        return count;
    }
}
