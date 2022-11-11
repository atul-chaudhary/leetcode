package com.atul.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTotalDistanceTraveled {
    public static void main(String[] args) {

    }

    private long solve(int x, int y, int n, int m ,List<Integer> robots, List<Integer> factory, Long[][] dp){
        if(x==n) return 0;
        if(y==m) return (long)1e13;
        if(dp[x][y] != null) return dp[x][y];
        long ans = (long)1e13;
        ans = Math.min(ans, solve(x+1, y+1, n, m, robots, factory, dp)+Math.abs(robots.get(x)-factory.get(y)));
        ans = Math.min(ans, solve(x, y+1, n,m, robots, factory, dp));
        return dp[x][y] = ans;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> factories = new ArrayList<>();
        for(int[] row : factory){
            for (int i = 0; i < row[1]; i++) {
                factories.add(row[0]);
            }
        }

        int n = robot.size();
        int m = factories.size();
        Collections.sort(robot);
        Collections.sort(factories);
        Long[][] dp = new Long[n][m];
        return solve(0,0, n, m, robot, factories, dp);
    }
}
