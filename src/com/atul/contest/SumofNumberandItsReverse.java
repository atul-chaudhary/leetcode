package com.atul.contest;

public class SumofNumberandItsReverse {
    public static void main(String[] args) {
        int num = 181;
        System.out.println(sumOfNumberAndReverse(num));
    }

    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            sb.reverse();
            if(Integer.parseInt(sb.toString()) + i == num){
                return true;
            }
        }
        return false;
    }
}
