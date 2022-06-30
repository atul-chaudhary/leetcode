package com.atul.binarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(binarySearch(arr));
    }

    private static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int len = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 && arr[mid] > arr[mid + 1]) ||
                    (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) ||
                    (mid + 1 < len && arr[mid] > arr[mid + 1] && mid - 1 >= 0 && arr[mid] > arr[mid - 1])) {
                return mid;
            } else if ((mid == 0 && arr[mid] < arr[mid + 1]) || (mid == arr.length - 1 && arr[mid] < arr[mid - 1]) || mid + 1 < len && arr[mid + 1] > arr[mid] && mid - 1 >= 0 && arr[mid - 1] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
