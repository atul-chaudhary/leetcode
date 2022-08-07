package com.atul.contest;

import java.util.Map;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s, k));
    }

    public static int longestIdealString(String s, int k) {
        return solve(s, 0, s.length()-1, k, "");
     }

    private static int solve(String s, int i, int n, int k,String cur){
        if(i==n){
            if(cur.length() >=1){
                if(cur.charAt(cur.length()-1)-s.charAt(i) <= k){
                    return 1;
                }
            }
            return 0;
        }

        int left = 0;
        if(i==0){
            left = solve(s, i+1, n, k, cur+s.charAt(i));
        }else if(Math.abs(s.charAt(i)-s.charAt(i+1)) <= k){
            left = solve(s, i+1, n , k, cur +s.charAt(i));
        }

        int right = solve(s, i+1, n, k, cur);

        return left+right;
    }

    private static int lcs(String a, String b, int n, int m, int k){
        if(n==0 || m==0){
            return 0;
        }

        if(a.charAt(n-1) == b.charAt(m-1) && Math.abs(a.charAt(n-1)-b.charAt(m-1)) <= k){
            return 1+ lcs(a, b, n-1, m-1, k);
        }else{
            return Math.max(lcs(a, b, n-1, m, k), lcs(a, b, n, m-1, k));
        }
    }
}
