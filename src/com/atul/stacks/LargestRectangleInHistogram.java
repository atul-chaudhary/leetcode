package com.atul.stacks;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};//{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int exten = heights[i];
            int count = 1;
            for (int j = i-1; j >=0 ; j--) {
                if(exten <= heights[j]){
                    count++;
                }else{
                    break;
                }
            }

            for (int j = i+1; j < heights.length; j++) {
                if(exten <= heights[j]){
                    count++;
                }else{
                    break;
                }
            }
            //System.out.println(exten*count);
            max = Math.max(max, exten*count);
        }
        return max;
    }
}
