package com.atul.dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {

        String[] arr = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(arr));
        System.out.println(longestStrChain(arr, 0, -1, arr.length));
    }

    private static int longestStrChain(String[] arr, int index, int prev, int n){
        if(index >= n) return 0;

        int notPick = longestStrChain(arr, index + 1, prev, n);
        int pick = 0;
        if(prev == -1 || arr[index].length() - longesCommonSub(arr[index], arr[prev], 0, 0, arr[index].length(), arr[prev].length())==1){
            pick = 1+ longestStrChain(arr, index +1, index, n);
        }
        return Math.max(pick, notPick);
    }



    private static int longesCommonSub(String a, String b, int i, int j, int n, int m){
        if(i >= n) return 0;
        if (j >= m) return 0;

        if(a.charAt(i)== b.charAt(j)){
            return 1+longesCommonSub(a, b, i+1, j+1, n, m);
        }else{
            return Math.max(
                    longesCommonSub(a, b, i, j+1, n, m),
                    longesCommonSub(a, b, i+1, j, n, m)
            );
        }
    }

    private int solve(String[] arr){
        int n = arr.length;
        int[] dp = new int[n];

        int max = 1;
        for(int i=0;i<n;i++){
            for(int prev = 0; prev < i;prev++){
                if(check(arr[i], arr[prev]) && 1+dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    private boolean check(String a, String b){
        if(a.length() == 1 + b.length()) return false;

        int first = 0;
        int second = 0;

        while(first < a.length()){
            if(a.charAt(first) == b.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        if(first == a.length() && second== b.length()) return true;
        else return false;
    }

    static int lSC(String[] arr){
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int n = arr.length;
        int[] dp = new int[n];
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkPossible(arr[i], arr[j]) && 1 + dp[j] > dp[i]){
                    dp[i] = 1+ dp[j];
                }
            }
            if (dp[i] > maxi){
                maxi = dp[i];
            }
        }
        return maxi + 1;
    }

    private static boolean checkPossible(String s, String s1) {
        if (s.length() != s1.length()+1){
            return false;
        }
        int first = 0;
        int second = 0;

        while (first < s.length()){
            if (second < s1.length() && s.charAt(first) == s1.charAt(second)){
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        if (first == s.length() && second == s1.length()){
            return true;
        }
        else return false;
    }
}
