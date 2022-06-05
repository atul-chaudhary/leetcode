package com.atul.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {

    }

    public List<String> letterCasePermutation(String s) {
        int index = 0;
        String curr = "";
        int len = s.length();
        ArrayList<String> arr = new ArrayList<String>();
        return permutation(s, index, curr, arr, len);
    }


    public ArrayList<String> permutation(String s, int index, String curr, ArrayList<String> arr, int len) {
        if (len == index) {
            arr.add(curr);
            return arr;
        }

        if (Character.isDigit(s.charAt(index))) {
            permutation(s, index + 1, curr + s.charAt(index), arr, len);
        } else {
            permutation(s, index + 1, curr + String.valueOf(s.charAt(index)).toLowerCase(), arr, len);
            permutation(s, index + 1, curr + String.valueOf(s.charAt(index)).toUpperCase(), arr, len);
        }
        return arr;
    }
}
