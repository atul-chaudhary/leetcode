package com.atul.contest;

import java.util.ArrayDeque;
import java.util.Stack;

public class Contest27_11_22 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String s = "coaching";
        String t = "coding";
        System.out.println(appendCharacters(s, t));
    }


    public static int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == t.length())
            return 0;
        return t.length() - j;
    }

    public static ListNode removeNodes(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode dummy = head;
        while (dummy != null) {
            while (!stack.isEmpty() && dummy.val > stack.peek()) {
                stack.pop();
            }
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        System.out.println(stack);
        ListNode newHead = new ListNode(-1);
        ListNode result = newHead;
        while (!stack.isEmpty()) {
            newHead.next = new ListNode(stack.pollLast());
            newHead = newHead.next;
        }
        return result.next;
    }

    private static void trav(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static int lcsDp(String a, String b, int n, int m, int[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lcs(String a, String b, int n, int m, Integer[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != null) {
            return dp[n][m];
        }

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(a, b, n - 1, m - 1, dp);
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(lcs(a, b, n, m - 1, dp), lcs(a, b, n - 1, m, dp));
            return dp[n][m];
        }
    }

    public static int pivotInteger(int n) {
        if (n == 1) return 1;
        for (int i = 1; i < n; i++) {
            int first = (int) sum(1, i);
            int second = (int) sum(i, n - i + 1);
            if (first == second) {
                return i;
            }
        }
        return -1;
    }

    private static double sum(int a, int n) {
        return (n * 1.0 / 2) * (2 * a + (n - 1));
    }
}
