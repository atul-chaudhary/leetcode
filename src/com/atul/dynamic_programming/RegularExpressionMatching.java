package com.atul.dynamic_programming;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        String sb = "";
        System.out.println(sb.length());
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    private static boolean solve(String s, String p, int i, int j){
        if(i >= s.length() && j < p.length()) return false;
        if(j >= p.length() && i < s.length()) return false;
        if(i == s.length() && j == p.length())  return true;

        if(s.charAt(i) == p.charAt(j)){
            return solve(s, p, i+1, j+1);
        }else if(p.charAt(j)=='?'){
            return solve(s, p, i+1,j+1);
        }else if(p.charAt(j)== '*'){
            return solve(s, p, i+1, j+1) || solve(s, p, i+1,j) || solve(s, p, i, j+1);
        }else if(s.charAt(i) != p.charAt(j)){
            return false;
        }
        return false;
    }
}
