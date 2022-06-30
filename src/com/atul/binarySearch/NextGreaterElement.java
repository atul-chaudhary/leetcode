package com.atul.binarySearch;

public class NextGreaterElement {
    public static void main(String[] args) {
        char[] s ={'a','b', 'c' , 'd'};
        System.out.println(nextGreatestLetter(s, 'a'));
    }
    public  static  char nextGreatestLetter(char[] letters, char target) {
        int ceil = binarySearch(letters, target);
        return letters[ceil];
    }

    private static int binarySearch(char[] arr, char target){
        int start = 0;
        int end = arr.length-1;
        int ceil = -1;
        while(start <= end){
            int mid = start+(end - start)/2;
            if(target < arr[mid]){
                ceil = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(ceil);
        return start%arr.length;
    }
}
