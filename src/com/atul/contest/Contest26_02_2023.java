package com.atul.contest;

import java.math.BigInteger;
import java.util.*;

class ThreadB extends Thread{
    @Override
    public void run() {
        super.run();
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("call from threadB "+i);
            }
            this.notify();
        }
    }
}

public class Contest26_02_2023 {
    public static void main(String[] args) throws InterruptedException {
       ThreadB threadB = new ThreadB();
       Thread.sleep(400);
       threadB.start();

    }

    
    static class Pair {
        int x;
        int y;
        int time;

        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(0, 0, 0));
        vis[0][0] = true;

        int[] xcor = new int[]{1, -1, 0, 0};
        int[] ycor = new int[]{0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.x;
            int y = pair.y;
            if (x == n - 1 && y == m - 1) {
                return pair.time;
            }
            for (int i = 0; i < 4; i++) {
                int newX = xcor[i] + x;
                int newY = ycor[i] + y;
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || vis[newX][newY]) continue;

                if (grid[newX][newY] <= pair.time + 1) {
                    pq.offer(new Pair(newX, newY, pair.time + 1));
                } else {
                    int diff = grid[newX][newY] - pair.time;
                    if (diff % 2 == 1) {
                        pq.offer(new Pair(newX, newY, pair.time + diff));
                    } else {
                        pq.offer(new Pair(newX, newY, pair.time + diff + 1));
                    }
                }
                vis[newX][newY] = true;
            }
        }
        return -1;
    }

    public static int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long remainder = 0;
        int[] div = new int[n];

        for (int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(word.charAt(i));
            remainder = (remainder * 10 + digit) % m;
            if (remainder == 0) {
                div[i] = 1;
            }
        }

        return div;
    }

    public static int[] divisibilityArray1(String word, int m) {
        int n = word.length();
        String cur = "";
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            cur += word.charAt(i);
            BigInteger bigInteger = new BigInteger(cur);
            if (bigInteger.mod(BigInteger.valueOf(m)).equals(BigInteger.ZERO)) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    private static int testMarkDickinson(String x, int y) {
        int acc = 0;
        for (int i = 0; i < x.length(); i++)
            acc = (acc * 10 + x.charAt(i) - '0') % y;
        return acc;
    }

    public static int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int num = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = num;
            num += nums[i];

        }
        num = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = num;
            num += nums[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(left[i] - right[i]);
        }
        return result;

    }
}
