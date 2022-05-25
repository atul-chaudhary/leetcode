package com.atul.strings;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String s = "god ding";
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        int len = s.length();
        while(j<len){
            while(j < len && s.charAt(j) != ' ') j++;
            System.out.println(j);
            sb.append(s, i, j);
            if(j+1 < len && s.charAt(j+1) != ' '){
                sb.append(" ");
            }
            i=j;
            j++;
            i++;
        }
        System.out.println(sb);
        return null;
    }

    public static String reverseWordsq(String s) {
        StringBuilder sb = new StringBuilder();

        int j=0;
        int i=0;
        int len = s.length();
        while(j<len){
            while(s.charAt(j) != ' ' && j < len) j++;
            sb.append(reverse(s.substring(i,j)));
            i = j;
            if(j>=len) break;
        }
        return null;
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
