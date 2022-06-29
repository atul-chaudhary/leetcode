package com.atul.binarySearch;

public class FloorInSortedArray {
    public static void main(String[] args) {
        int[] arr  ={1,3,5,6};
        System.out.println(binarySearch(arr, 5));
    }

    private static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        while(start <= end){
            mid = (start+end)/2;
            if(target == arr[mid]){
                //System.out.println(mid);
                return mid;
            }else if(target < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return mid;
    }
}
