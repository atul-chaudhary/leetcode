package com.atul.recursion;

import java.util.ArrayList;

public class PermutationWithSpaces {
    public static void main(String[] args) {
        permutation("ABC");
    }

    public static ArrayList<String> permutation(String S) {
        // Code Here
        int index = 1;
        String curr = ""+S.charAt(0);
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(permRec(S, index, curr, arrayList));

        return null;
    }

    public static ArrayList<String> permRec(String s, int index, String curr, ArrayList<String> arr){
        int l = s.length();
        if(index==l){
            arr.add(curr);
            return arr;
        }

            permRec(s, index+1, curr+" "+s.charAt(index), arr);
            permRec(s, index+1, curr+s.charAt(index),arr);
        return arr;
    }

}
