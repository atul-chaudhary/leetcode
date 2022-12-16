package com.atul.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumNumberOfPointsWithCost {
    public static void main(String[] args) {
        int[][] arr = {{1, 5}, {2, 3}, {4, 2}};
        System.out.println(maxPoints(arr));
    }


    public static long maxPoints(int[][] points) {
        Map<String, Long> dp = new HashMap<>();
        return solve(points, 0, 0, new ArrayList<>(), dp);
    }

    private static long solve(int[][] arr, int row, long sum, List<Integer> cols, Map<String, Long> dp){
        if(row == arr.length){
            int n = cols.size();
            int sub = 0;
            for (int i = n-1; i >= 1; i--) {
                sub+=Math.abs(cols.get(i)-cols.get(i-1));
            }
            return sum - sub;
        }
        String s= row + ":"+sum;
        if(dp.containsKey(s)) return dp.get(s);
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            cols.add(i);
            ans = Math.max(ans, solve(arr, row+1, sum+arr[row][i], cols, dp));
            cols.remove(cols.size()-1);
        }
        dp.put(s,ans);
        return ans;
    }

}
