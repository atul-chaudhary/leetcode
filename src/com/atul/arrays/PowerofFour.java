package com.atul.arrays;

public class PowerofFour {
    public static void main(String[] args) {
        System.out.println(-2147483648%4);
    }

    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        if(n % 4 ==  0){
            return true;
        }else{
            return false;
        }
    }
}
