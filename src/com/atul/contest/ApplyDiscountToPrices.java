package com.atul.contest;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ApplyDiscountToPrices {
    public static void main(String[] args) {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        String s = "10$";
        discountPrices(s, 50);
    }

    public static String discountPrices(String s, int discount) {
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            String temp = arr[i];
            if(temp.charAt(0) == '$' && temp.length() >=2 && temp.charAt(1)-'0' >=0){
                System.out.println("n");
                double d = Double.parseDouble(temp.substring(1));
                d = d*(1-discount*1.0/100);
                arr[i] = String.format("%.2f", d);
            }
        }
        return String.join(" ", arr);
    }
}
