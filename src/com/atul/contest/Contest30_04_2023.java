package com.atul.contest;

import java.util.*;

public class Contest30_04_2023 {
    public static void main(String[] args) {
        int[] nums = {9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        long num = 1;
        int neg = 0;
        boolean isZero = false;
        for (int it : nums) {
            if (it == 0) {
                isZero = true;
            }

            if (it < 0) {
                neg++;
            }
        }

        if (isZero) return 0;
        else if (neg % 2 == 0) return 1;
        else return 0;
    }

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        int y1 = 0;
        int y2 = n - 1;
        for (int i = 0; i < n; i++) {
            if (y1 == y2) {
                sum += mat[i][y1];
                y1++;
                y2--;
            } else {
                sum += mat[i][y1++];
                sum += mat[i][y2--];
            }
        }
        return sum;
    }

    public static double average(int[] salary) {
        int n = salary.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int it : salary) {
            min = Math.min(min, it);
            max = Math.max(max, it);
            sum += it;
        }
        double exc = sum - (min + max);
        return exc / (n - 2);
    }

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length;
        int xs1 = start[0];
        int ys1 = start[1];
        int xd1 = target[0];
        int yd1 = target[1];
        List<int[]> spec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x1 = specialRoads[i][0];
            int y1 = specialRoads[i][1];
            int x2 = specialRoads[i][2];
            int y2 = specialRoads[i][3];
            int dist = specialRoads[i][4];
            int cal = solve(x1, y1, x2, y2);
            if (dist <= cal) {
                spec.add(specialRoads[i]);
            }
        }
        return 0;
    }

    private static int solve(int[] cur, int[] dest, List<int[]> spec, int index) {
        if (index >= spec.size()) {
            return 0;
        }
        int pick = solve(cur[0], cur[1], spec.get(index)[0], spec.get(index)[1]) + spec.get(index)[4] + solve(new int[]{spec.get(index)[2], spec.get(index)[3]}, dest, spec, index + 1);
        int notPick = solve(cur, dest, spec, index + 1);
        return Math.min(pick, notPick);
    }

    private static int solve(int x1, int y1, int x2, int y2) {
        return Math.abs(y2 - y1) + Math.abs(x2 - x1);
    }

    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length;
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, Set<Integer>> col = new HashMap<>();
        for (int i = 0; i < m; i++) {
            col.put(i, new HashSet<>());
        }
        Map<Integer, Set<Integer>> row = new HashMap<>();
        for (int i = 0; i < n; i++) {
            row.put(i, new HashSet<>());
        }
        Map<Integer, Pair> info = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                info.put(mat[i][j], new Pair(i, j));
            }
        }

        for (int i = 0; i < len; i++) {
            int num = arr[i];
            Pair p = info.get(num);
            int colIndex = p.col;
            int rowIndex = p.row;
            col.get(colIndex).add(rowIndex);
            if (col.get(colIndex).size() == n) {
                return i;
            }

            row.get(rowIndex).add(colIndex);
            if (row.get(rowIndex).size() == m) {
                return i;
            }
        }
        return -1;
    }

    public static int isWinner(int[] player1, int[] player2) {
        int n = player1.length;
        int m = player2.length;
        int t1 = 0;
        boolean hit1 = false;
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                t1 += player1[i];
                if (player1[i] == 10) {
                    hit1 = true;
                }
            } else {
                if (hit1) {
                    t1 += 2 * player1[i];
                } else {
                    t1 += player1[i];
                }
                if (player1[i] == 10) {
                    hit1 = true;
                }
            }
        }
        int t2 = 0;
        boolean hit2 = false;
        for (int i = 0; i < m; i++) {
            if (i <= 1) {
                t2 += player2[i];
                if (player2[i] == 10) {
                    hit2 = true;
                }
            } else {
                if (hit2) {
                    t2 += 2 * player2[i];
                } else {
                    t2 += player2[i];
                }
                if (player2[i] == 10) {
                    hit2 = true;
                }
            }
        }

        if (t1 == t2) return 0;
        else if (t1 > t2) return 1;
        else return 2;
    }
}
