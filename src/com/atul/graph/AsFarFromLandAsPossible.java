package com.atul.graph;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {

    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        List<Pair> list = new ArrayList<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(new Pair(i, j));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int count = Integer.MAX_VALUE;
                    for (int k = 0; k < list.size(); k++) {
                        int num = Math.abs(i - list.get(k).x) + Math.abs(j - list.get(k).y);
                        count = Math.min(count, num);
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

}
