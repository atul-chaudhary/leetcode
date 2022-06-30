package com.atul.binarySearch;

public class MinimumDifferenceElementInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 15};
        int target = 12;
        System.out.println(bs(arr, target));
    }

    private static int bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean flg = false;
        int mid = 0;
        while (start <= end){
            mid = start + (end - start) /2;
            if(arr[mid] == target){
                flg = true;
                break;
            }else if(target < arr[mid]){
                end  = mid - 1;
            }else {
                start = mid+1;
            }
        }
        if(flg) return arr[mid];
        else return Math.min(Math.abs(arr[start]-target), Math.abs(arr[end]-target));
        //return mid;
    }

}
