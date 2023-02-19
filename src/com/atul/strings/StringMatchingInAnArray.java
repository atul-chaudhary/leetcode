package com.atul.strings;


import java.util.*;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        String s = "a1b2c3d4e";
        System.out.println(replaceDigits(s));
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        solve(root, result);
        int size = result.size();
        int number = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            number = Math.min(number, result.get(i)-result.get(i-1));
        }
        return number;
    }

    private static void solve(TreeNode root, List<Integer> inroder) {
        if (root == null) return;
        solve(root.left, inroder);
        inroder.add(root.val);
        solve(root.right, inroder);
    }

    public static String replaceDigits(String s) {
        int n = s.length();
        String result = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int prev = s.charAt(i - 1) - 'a';
                int num = Integer.parseInt(String.valueOf(ch));
                int finalNum = prev + num + 'a';
                result += (char) finalNum;
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long[] nums = new long[n];
        nums[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            nums[i] = (long) shifts[i] + nums[i + 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int finalNum = (int) ((ch + nums[i]) % 26.0 + 'a');
            sb.append((char) finalNum);
        }
        return sb.toString();
    }

    static class TreeNode {
        TreeNode left, right;
        int val;

    }

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        int ans = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            ans++;

            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if (node.left != null) {
                    pq.offer(node.left);
                }

                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
        }

        return ans;
    }

    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (words[i].contains(words[j])) {
                    result.add(words[j]);

                }
            }
        }
        return new ArrayList<>(result);
    }
}
