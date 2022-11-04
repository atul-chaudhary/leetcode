package com.atul.stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));
    }

    public static int evalRPN(String[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    if (s.equals("+")) {
                        stack.push(first + second);
                    } else if (s.equals("-")) {
                        stack.push(second - first);
                    } else if (s.equals("*")) {
                        stack.push(first * second);
                    } else {
                        stack.push(second / first);
                    }
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
