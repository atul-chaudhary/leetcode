package com.atul.binarySearch;

public class First1InBinarySortedArray {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,1,1,1,1,1};
        System.out.println(you(arr));
    }

    private static int you(int [] arr){
        int start = 0;
        int end = 1;

        while(arr[end] < 1){
            start = end;
            end = end *2;
        }

        return bsInf(arr, start, end);
    }
    private static int bsInf(int[] arr, int start, int end){
        int res = -1;
        while(start <= end){
            int mid = start +(end- start)/2;
            if(arr[mid] == 1){
                res = mid;
                end = mid-1;
            }else if(arr[mid] < 1){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }

    private  static int bs(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int n = arr.length;
        while(start <= end){
            int mid= start + (end-start)/2;
            int prev = (mid-1+ n)%n;
            if(arr[mid] == 1){
                if(arr[prev] == 1){
                    end = mid-1;
                }else{
                    return mid;
                }
            }else if(arr[mid] < 1){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
