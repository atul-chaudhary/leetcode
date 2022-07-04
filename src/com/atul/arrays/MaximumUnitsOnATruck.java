package com.atul.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int[][] arr = {{5,10},{2,5},{4,7},{3,9}};
        int truckSize = 10;
        Arrays.sort(arr, (o1, o2) -> {
            Integer x = o1[1];
            Integer y = o2[1];
            return y.compareTo(x);
        });
        int i=0;
        int count = 0;
        while(truckSize != 0){
            if(truckSize > arr[i][0]){
                count += arr[i][0] * arr[i][1];
                truckSize -= arr[i][0];
            }else{
                count += truckSize* arr[i][1];
                truckSize -= truckSize;
            }
            i++;
        }
        System.out.println(count);
    }
}
