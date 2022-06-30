package com.atul.binarySearch;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {{10,20,30,40},{15,25,35,45},{27,29,37,45},{32,33,39,50}};
        System.out.println(binary(arr, 29));
    }

    private static boolean binary(int[][] arr, int target){
        int rowStart = 0;
        int rowEnd = arr.length-1;
        int colStart = 0;
        int colEnd = arr[0].length-1;
        int i = 0,j = colEnd;
        while((i >= rowStart && i <= rowEnd)  && (j >= colStart && j <= colEnd )){
            int pos = arr[i][j];
            if(pos == target){
                return true;
            }else if(target < pos){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

}
