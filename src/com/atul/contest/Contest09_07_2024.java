package com.atul.contest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Contest09_07_2024 {
    public static void main(String[] args) {
        char ch[][] = {{'X', 'Y', '.'}, {'Y', '.', '.'}};
        System.out.println(numberOfSubmatrices(ch));
    }

    static class Tuple {
        int x;
        int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    "x " + x +
                    ", y " + y +
                    '}';
        }
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Tuple[][] dp = new Tuple[n][m];
        for (int i = 0; i < n; i++) {
            Tuple temp = new Tuple(0, 0);
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') temp.x++;
                if (grid[i][j] == 'Y') temp.y++;
                dp[i][j] = temp;
            }
        }

        System.out.println(Arrays.deepToString(dp));
        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < n; j++) {
                Tuple temp = dp[j][i];
                x += temp.x;
                y += temp.y;
                if (x == y) {
                    count++;
                }
            }
        }
        return count;
    }
}
