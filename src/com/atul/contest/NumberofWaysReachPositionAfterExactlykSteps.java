package com.atul.contest;

import java.util.HashMap;

public class NumberofWaysReachPositionAfterExactlykSteps {
    public static void main(String[] args) {
        System.out.println(numberOfWays(989, 1000, 99));
    }

    public static int numberOfWays(int startPos, int endPos, int k) {
        Integer[][] dp = new Integer[2001][2001];
        return solve(startPos, endPos, k, dp);
    }

    private static int solve(int start, int endPost, int k, Integer[][] dp){
        if(Math.abs(start-endPost) > k) return 0;
        if(k==0){
            if(start== endPost){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[start < 0 ? start+2000 : start][k] != null) return dp[start < 0 ? start+2000 : start][k];
        return  dp[start < 0 ? start+2000 : start][k] = solve(start + 1, endPost, k - 1, dp) + solve(start - 1, endPost, k - 1, dp);
    }

    public int solve(int startPos, int endPos, int k , HashMap<String, Integer> map) {
        if(k == 0) {
            if(startPos == endPos)
                return 1;
            return 0;
        }
        if(Math.abs(startPos-endPos) >k)
            return 0;
        String key  = startPos+"#"+k;
        if(map.containsKey(key))
            return map.get(key);

        int left_val =  solve(startPos+1, endPos, k-1, map);
        int right_val =  solve(startPos-1, endPos, k-1,map);
        map.put(key, ((left_val+right_val)%1000000007));
        return  ((left_val+right_val)%1000000007);
    }

}
