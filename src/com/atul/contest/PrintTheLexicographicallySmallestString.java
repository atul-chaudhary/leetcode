package com.atul.contest;

import java.util.Stack;

public class PrintTheLexicographicallySmallestString {
    public static void main(String[] args) {
        String s = "bac";
        //System.out.println(robotWithString(s));
    }

    /*public static String robotWithString(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty() && i < n && stack.peek() > s.charAt(i)) {
                sb.append(s.charAt(i));
                i++;
            }
            if (i < n)
                if()
        }
        System.out.println(stack);
        System.out.println(sb.toString());
        return "";
    }

     */
}
