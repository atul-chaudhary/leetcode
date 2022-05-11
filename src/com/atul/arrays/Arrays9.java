package com.atul.arrays;

import java.util.Arrays;

public class Arrays9 {
    public static void main(String[] args) {
        int[][] points = {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries = {{2,3,1},{4,3,1},{1,1,2}};
        System.out.println(Arrays.toString(countPoints(points, queries)));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                double xOpet =  Math.pow((queries[k][0] - points[i][0]),2);
                double yOpet = Math.pow(queries[k][1] - points[i][1], 2);
                double cal = xOpet + yOpet;
                double distance = Math.pow(cal, 0.5);
                if(distance <= queries[k][2]){
                    count++;
                }
            }
            result[k] = count;
        }
        return result;
    }
}
