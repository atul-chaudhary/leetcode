package com.atul.arrays;

public class Arrays5 {
    public static void main(String[] args) {
        String[] arr = {"X++","++X","--X","X--"};
        System.out.println(finalValueAfterOperations(arr));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for(String s : operations){
            if (s.charAt(1)== '+')//if(s.equals("++X") || s.equals("X++"))
                count++;
            else
                count--;
        }
        return count;
    }
}
