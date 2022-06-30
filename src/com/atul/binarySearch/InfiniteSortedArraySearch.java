package com.atul.binarySearch;

import java.util.ArrayList;

public class InfiniteSortedArraySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i+1);
        }
        int target = 165;
        System.out.println(binarySearch(arrayList, target));
    }

    private static int binarySearch(ArrayList<Integer> arr, int target){
        int left = 0;
        int right = 1;

        while(arr.get(right) < target){

            left = right;
            right *= 2;
        }
        System.out.println(left+ " "+ right);
        return mainSearch(arr, left, right, target);
    }

    private static int mainSearch(ArrayList<Integer> arrayList, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) /2;
            if(target== arrayList.get(mid)){
                return mid;
            }else if(target < arrayList.get(mid)){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
