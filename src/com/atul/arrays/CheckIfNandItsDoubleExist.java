package com.atul.arrays;

import java.util.HashMap;

public class CheckIfNandItsDoubleExist {
    public static void main(String[] args) {

        int[] arr = {0,0};//{-2,0,10,-19,4,6,-8};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        System.out.println(hashMap);
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i] * 2) && hashMap.get(arr[i] * 2) != i) {
                return true;
            }
        }
        return false;
    }

}
