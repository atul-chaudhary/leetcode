package com.atul.recursion;

public class FactorialRecursion {
    public static void main(String[] args) {
        //System.out.println(factorial(5));
        //System.out.println(sum(10));
        //System.out.println(fibonacci(9));
        //printArray(new int[]{1,2,3,4,5}, 4);
        System.out.println(countDigit(123));
    }

    public static int factorial(int num){
        if (num==0 || num==1){
            return 1;
        }
        return num*factorial(num-1);
    }

    public static int sum(int num){
        if (num==1) return 1;
        return sum(num-1)+num;
    }

    public static int fibonacci(int num){
        if (num <=1){
            return num;
        }
        return fibonacci(num-1) + fibonacci(num-2);
    }

    int[] arr = {1,2,3,4,5};
    int len = arr.length;
    public static void printArray(int[] arr, int len){
        if(len  < 0){
            return;
        }
        printArray(arr, len-1);
        System.out.println(arr[len]);
    }

    public static int countDigit(int num){
        if (num < 0){
            return 0;
        }
        return countDigit(num/10);
    }
}
