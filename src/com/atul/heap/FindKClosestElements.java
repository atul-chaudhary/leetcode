package com.atul.heap;

import java.util.*;

public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,3,6,8,8,9};
        //System.out.println(arr.length);
        System.out.println(findClosestElements(arr, 5, 9    ));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        System.out.println(index);
        int left = index-1;
        int right = index;
        List<Integer> list = new LinkedList<>();
        while(left >=0 && right <= arr.length-1 && k > 0){
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                //list.add(arr[left]);
                left--;
            }else{
                //list.add(arr[right]);
                right++;
            }
            k--;
        }
        while(k > 0 && left >=0){
            //list.add(arr[left]);
            left--;
            k--;
        }

        while(k > 0 && right < arr.length){
            //list.add(arr[right]);
            right++;
            k--;
        }
        System.out.println(left+ " "+right);
//        List<Integer> list = new ArrayList<>();
//        for(int i=left;i<=right;i++){
//            list.add(arr[i]);
//        }
        return list;
    }

    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(arr[mid]== target){
                return mid;
            }else if(target > arr[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return mid;
    }
}
