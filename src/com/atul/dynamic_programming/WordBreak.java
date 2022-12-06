package com.atul.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        List<String> word = Arrays.asList("leet", "code");
        String s = "leetcode";
        System.out.println(wordBreak(s, word));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        return solve(s, new HashSet<>(wordDict), 0, dp);
    }

    private static boolean solve(String s, Set<String> set, int index, Boolean[] dp) {
        int n = s.length();
        if(index == n) return true;
        if(dp[index] != null) return dp[index];
        for (int i = index+1; i <= n; i++) {
            if (set.contains(s.substring(index, i)) && solve(s, set, i, dp)) {
                return dp[index] =  true;
            }
        }
        return dp[index] = false;
    }
}
