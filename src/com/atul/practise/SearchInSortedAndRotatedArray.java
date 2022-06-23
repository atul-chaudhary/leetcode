package com.atul.practise;

public class SearchInSortedAndRotatedArray {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10,1,2,3};

    }

    public int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]){
                return mid;
            }else{

            }
        }
        return 0;
    }
}
