package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        int k = 5;
        //getRow(k);
        getRowUsingCombination(k);
    }

    public List<Integer> getRowQ(int i) {
        ArrayList<Integer> arr = new ArrayList<>();
        long val = 1;
        for(int j=0;j<=i;j++){
            arr.add((int)val);
            val = val *(i-j) / (j+1);
        }
        return arr;
    }

    public static void generateEntirePascal(int rowIndex) {
        int[][] arr = new int[rowIndex][rowIndex];
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
            }
        }
        //return the row which is asked;
    }

    public static List<Integer> getRowUsingCombination(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            list.add(findCombination(rowIndex,i));
        }
        System.out.println(list);
        return null;
    }

    public static int findCombination(int top, int bottom){
        if(bottom == 0 || top == bottom){
            return 1;
        }else{
            int num=0;
            int deno = 0;
            int i=1;
            while(i<=bottom){
                num = top*i;
                i++;
            }
            i=1;
            while(i<=bottom){
                deno = i*deno;
                i++;
            }
            return num/deno;
        }
    }

}
