package com.atul.binarySearch;

public class CountNegativeNumbersSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{3,2},{1,0}};//{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(arr));
    }

    public static int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            int result = binarySearch(grid[i]);
            System.out.println(result);
            if(result == -1){
                count+=m;
            }else if(result != m - 1){
                count+= m-result-1;
            }
            //System.out.println(count);
        }
        return count;
    }

    private static int binarySearch(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int res = -1;
        while(left <=right){
            int mid = (right + left)/2;
            if(arr[mid] >= 0){
                res = mid;
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }
}
