package com.atul.contest;

public class StrictlyPalindromicNumber {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(isStrictlyPalindromic(n));
    }

    public static boolean isStrictlyPalindromic(int n) {
        for(int i= 2;i<=n-2;i++){
            String s = convertFromBaseToBase(""+n, 10, i);
            if(!checkPlain(s)){
                return false;
            }
        }
        return true;
    }

    private static boolean checkPlain(String s){
        int first = 0;
        int last = s.length()-1;
        while(first < last){
            if(s.charAt(first) != s.charAt(last)){
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }
}
