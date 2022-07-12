package com.atul.dynamic_programming;

import java.util.ArrayList;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(minCut(s));
    }

    public static int minCut(String s) {
        int n = s.length();
        //solve(s, 0, n - 1);
        return 0;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void solve(String s, int i, int j, String asf, ArrayList<ArrayList<String>> arrayList) {
        if (i >= j) {
            //arrayList.add
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            String res = s.substring(i, k + 1);
            if (isPalindrome(s, i, k)) {
                String ros = s.substring(k + 1);
                //solve(s, k+1, j, arrayList.add());
            }
        }
    }
}
