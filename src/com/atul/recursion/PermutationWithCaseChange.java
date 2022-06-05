package com.atul.recursion;

import java.util.ArrayList;

public class PermutationWithCaseChange {

    public static void main(String[] args) {

        int index = 0;
        String s = "abc";
        String curr = "";
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(permutationWithCaseChange(s, index, curr, arrayList));
    }

    public static ArrayList<String> permutationWithCaseChange(String s, int index, String curr, ArrayList<String> arrayList){
        int len = s.length();
        if(index==len){
            arrayList.add(curr);
            return arrayList;
        }

        permutationWithCaseChange(s, index+1, curr+ String.valueOf(s.charAt(index)).toLowerCase(), arrayList);
        permutationWithCaseChange(s, index+1, curr+(String.valueOf(s.charAt(index)).toUpperCase()), arrayList);
        return arrayList;

    }
}
