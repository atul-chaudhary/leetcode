package com.atul.strings;


import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(calculate_(s));
    }

    public static int calculate_(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
        }
        Stack<String> stack = new Stack<>();
        int i=0;
        while (i<s.length()){
            if(s.charAt(i)=='/'){
                int a = Integer.parseInt(stack.pop());
                int b = s.charAt(i+1)-'0';
                stack.push(String.valueOf(a/b));
                i+=2;
            }else if(s.charAt(i)=='*'){
                System.out.println(stack);
                int a = Integer.parseInt(stack.pop());
                int b = s.charAt(i+1)-'0';
                stack.push(String.valueOf(a*b));
                i+=2;
            }else if(s.charAt(i)!=' '){
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            }else{
                i++;
            }
        }
        System.out.println(stack);
        while(stack.size() > 1){
            int a = Integer.parseInt(stack.pop());
            String sym = stack.pop();
            int b = Integer.parseInt(stack.pop());
            int cal = sym.equals("+") ? a+b : a-b;
            stack.push(String.valueOf(cal));
        }

        return stack.size()==1 ? Integer.parseInt(stack.pop()) : -1;
    }

        public static int calculate(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        while(sb.indexOf("*") !=-1 || sb.indexOf("+") !=-1 || sb.indexOf("-") !=-1|| sb.indexOf("/")!=-1){
            int index = -1;
            if(sb.indexOf("*")!=-1){
                index = sb.indexOf("*");
                int num = (sb.charAt(index-1)-'0') * (sb.charAt(index+1)-'0');
                //System.out.println(num);
                sb.replace(index-1, index+2, String.valueOf(num));
                //System.out.println(sb.toString());
            }else if(sb.indexOf("/")!=-1){
                index = sb.indexOf("/");
                int num = (sb.charAt(index-1)-'0') / (sb.charAt(index+1)-'0');
                sb.replace(index-1, index+2, String.valueOf(num));
            }else if(sb.indexOf("-")!=-1){
                index = sb.indexOf("-");
                int num = (sb.charAt(index-1)-'0') - (sb.charAt(index+1)-'0');
                sb.replace(index-1, index+2, String.valueOf(num));
            }else{
                index = sb.indexOf("+");
                int num = (sb.charAt(index-1)-'0') + (sb.charAt(index+1)-'0');
                sb.replace(index-1, index+2, String.valueOf(num));
            }
        }
        return Integer.parseInt(String.valueOf(sb));
    }
}
