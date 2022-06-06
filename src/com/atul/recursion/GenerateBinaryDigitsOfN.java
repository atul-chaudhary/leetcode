package com.atul.recursion;

import java.util.ArrayList;

public class GenerateBinaryDigitsOfN {
    public static void main(String[] args) {
        String s = "";
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(problem(s, 4, arrayList));
    }

    public static ArrayList<String> problem(String s, int n ,ArrayList<String> arr){
        if (n==0){
            arr.add(s);
            return arr;
        }

        problem(s+"1", n-1, arr);
        problem(s+"0",n-1, arr);

        return arr;
    }
}
