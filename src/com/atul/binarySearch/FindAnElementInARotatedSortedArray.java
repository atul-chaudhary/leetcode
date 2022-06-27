package com.atul.binarySearch;

public class FindAnElementInARotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }

    public static int search(int[] nums, int target) {
        int pivot = pivot(nums);
        System.out.println(pivot);
        if(nums[pivot] == target) return pivot;
        int first = binarySearchFirst(nums, pivot, nums.length-1, target);
        if(first == -1){
            return binarySearchFirst(nums, 0, pivot -1, target);
        }else{
            return first;
        }
    }

    private static int pivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int n = arr.length;
        while(start <= end){
            int mid = start + (end-start)/   2;
            int prev = (mid-1+n) % n;
            int next = (mid+1)%n;

            if(arr[mid] <= arr[prev] & arr[mid] <= arr[next]){
                return mid;
            }else if(arr[mid] <= arr[end]){
                end = mid-1;
            }else if(arr[mid] >= arr[start]){
                start = mid+1;
            }
        }
        return 0;
    }

    private static int binarySearchFirst(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end- start) /2;
            if(arr[mid] == target){
                return mid;
            }else if(target < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
