package com.atul.stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{[(";
        String q = "[()(){}{{}}]";
        System.out.println(isValid(q));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                Character temp = stack.peek();
                if(map.get(temp).equals(s.charAt(i))){
                    stack.pop();
                }else  {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
