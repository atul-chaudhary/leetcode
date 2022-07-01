package com.atul.binarySearch;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateMInNUmberOfPages {
    public static void main(String[] args) {
        int[] arr = {12,34,67,90};
        System.out.println(bruteForce(arr));
    }

    private static int bruteForce(int[] arr){
        ArrayList<int[]> arrayList = new ArrayList<>();
        int ithSum = 0;
        for(int i=0;i< arr.length;i++){
            ithSum += arr[i];
            int jthSum = 0;
            int[] temp = new int[2];
            for (int j = i+1; j < arr.length; j++) {
                jthSum += arr[j];
            }
            temp[0] = ithSum;
            temp[1] = jthSum;
            System.out.println(Arrays.toString(temp));
            arrayList.add(temp);
        }

        int min = Integer.MAX_VALUE;
        for(int[] it: arrayList){
            min = Math.min(min,  Math.max(it[0], it[1]));
        }
        return min;
    }
}
