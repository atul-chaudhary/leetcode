package com.atul.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public  static List<String> generateParenthesis(int n) {
        String s = "";
        ArrayList<String> arr = new ArrayList<>();
        return parenthesis(s, n, n, arr);
    }

    public static ArrayList<String> parenthesis(String s, int input, int output, ArrayList<String> arr) {
        if (input == 0 && output == 0) {
            arr.add(s);
            return arr;
        }
        if (input == output && output != 0) {
            parenthesis(s + "(", input - 1, output, arr);
        } else if (input < output && input != 0 && output != 0) {
            parenthesis(s + "(", input - 1, output, arr);
            parenthesis(s + ")", input, output - 1, arr);
        } else if (input == 0 && output != 0) {
            parenthesis(s + ")", input, output - 1, arr);
        }

        return arr;
    }
}
