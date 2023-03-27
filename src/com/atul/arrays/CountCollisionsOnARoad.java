package com.atul.arrays;

import java.util.Stack;

public class CountCollisionsOnARoad {
    public static void main(String[] args) {
        String str = "RRRRLL";//"LLRR";
        System.out.println(countCollisions(str));
    }

    public static int countCollisions(String str) {
        int n = str.length();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int col = 0;
        while (index < n) {
            char cur = str.charAt(index);
            if (stack.isEmpty()) {
                stack.push(cur);
                index++;
            } else if (stack.peek() == 'S' && cur == 'L') {
                col += 1;
                index++;
            } else if (stack.peek() == 'R' && cur == 'L') {
                stack.pop();
                stack.push('S');
                col += 2;
                index++;
            } else if (stack.peek() == 'R' && cur == 'S') {
                stack.pop();
                stack.push('S');
                col += 1;
                //index++;
            } else {
                stack.push(cur);
                index++;
            }
        }
        return col;
    }
}
