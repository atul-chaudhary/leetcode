package com.atul.contest;


import java.util.Arrays;

public class Contest18_02_2023 {
    public static void main(String[] args) {
        int num = 456;
        System.out.println(minMaxDifference(num));
    }



    public static int minMaxDifference(int num) {
        String number = String.valueOf(num);
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        int len = number.length();
        for (int i = 0; i < len; i++) {
            int curr = number.charAt(i)-'0';
            String temp = number;
            temp = temp.replaceAll(""+curr, ""+9);
            maxNumber = Math.max(maxNumber, Integer.parseInt(temp));

            temp = number;
            temp = temp.replaceAll(""+curr, ""+0);
            minNumber = Math.min(minNumber,Integer.parseInt(temp));
        }
        return maxNumber-minNumber;
    }
}
