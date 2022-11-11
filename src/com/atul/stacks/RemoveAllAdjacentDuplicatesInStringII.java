package com.atul.stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        System.out.println(removeDuplicates(s, 2));
    }

    static class Pair{
        char ch;
        int num;

        public Pair(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }

    public static String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(!stack.isEmpty() && stack.peek().ch == s.charAt(i)){
                Pair pair = stack.pop();
                pair.num++;
                stack.push(pair);

                if(stack.peek().num == k){
                    stack.pop();
                }
            }else {
                Pair pair = new Pair(s.charAt(i), 1);
                stack.push(pair);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            for (int i = 0; i < pair.num; i++) {
                sb.append(pair.ch);
            }
        }
        return sb.reverse().toString();
    }
}
