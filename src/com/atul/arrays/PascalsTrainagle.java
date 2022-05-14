package com.atul.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTrainagle {
    public static void main(String[] args) {
//        int[][] mat = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j <= i; j++) {
//                //System.out.print(1+ " ");
//                if(j==0 || j== i){
//                    mat[i][j] = 1;
//                }else {
//                    mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
//                }
//            }
//        }
//
//        for (int[] i : mat){
//            System.out.println(Arrays.toString(i));
//        }

        directlyGenerateRows();

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if(j == 1 || j== i){
                    temp.add(1);
                }else {
                    int num = list.get(i-1).get(i-1) + list.get(i-1).get(j);
                    temp.add(num);
                }
                list.add(temp);
            }
        }
        System.out.println(list);
        return null;
    }

    public static void directlyGenerateRows(){
        for (int i = 5,  c= 1; i  >= 1; i--) {
            int num = createCombination(i, c);
            System.out.println(i+ " "+c);
            c++;
            //System.out.print(num+ " ");

        }
    }

    public static int createCombination(int r, int c){
        int num  = 1;
        int den = 1;
        if(c== 1){
            //System.out.println(1);
        }
        for (int i = r-1; i  >= c ; i--) {
            //System.out.println(i);
            num *= i;
        }
        for (int i = c-1; i >=1 ; i--) {
            den *= i;
        }
        return num/den;
    }
}
