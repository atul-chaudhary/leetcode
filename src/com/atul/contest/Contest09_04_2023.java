package com.atul.contest;

import java.util.HashMap;
import java.util.*;


public class Contest09_04_2023 {

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        Integer[][] dp = new Integer[n + 1][n + 1];
        return solve(s, s2, 0, 0, dp);
    }

    private static int solve(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + solve(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(solve(s1, s2, i + 1, j, dp), solve(s1, s2, i, j + 1, dp));
        }
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int m = popped.length;
        Stack<Integer> stack = new Stack<>();
        int[] index = new int[1];
        for (int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            solve(stack, popped, index);
        }
        while (!stack.isEmpty() && index[0] < m) {
            if (stack.peek() != popped[index[0]]) {
                return false;
            } else {
                stack.pop();
                index[0]++;
            }
        }
        return true;
    }

    private static void solve(Stack<Integer> stack, int[] poped, int[] index) {
        while (!stack.isEmpty() && stack.peek() == poped[index[0]]) {
            stack.pop();
            index[0]++;
        }
    }


    public static String simplifyPath(String path) {
        String[] nums = path.split("/");
        System.out.println(Arrays.toString(nums));
        Stack<String> stack = new Stack<>();
        stack.push("/");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length() >= 1) {
                if (nums[i].equals("..")) {
                    if (stack.size() > 1 && stack.peek().equals("/")) stack.pop();
                    if (!stack.isEmpty() && !stack.peek().equals("/")) {
                        stack.pop();
                    }
                } else if (!nums[i].equals(".")) {
                    stack.push(nums[i]);
                    stack.push("/");
                }
            }
        }
        if (!stack.isEmpty() && stack.peek().equals("/")) stack.pop();
        if (stack.isEmpty()) stack.push("/");
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static boolean backspaceCompare(String s, String t) {
        String first = solve(s);
        String sec = solve(t);
        return first.equals(sec);
    }

    private static String solve(String s) {
        int n = s.length();
        int star = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                star++;
            } else {
                if (star == 0) {
                    sb.insert(0, s.charAt(i));
                } else {
                    star--;
                }
            }
        }
        return sb.toString();
    }

    public static String removeStars(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    public static int minimizeMax(int[] nums, int p) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        Arrays.sort(nums);
        int end = nums[nums.length - 1] - nums[0];
        while (start <= end) {
            int mid = (start + (end - start) / 2);
            int count = solve(nums, mid);
            if (count >= p) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }

    public static int solve(int[] nums, int num) {
        int count = 0;
        for (int i = 1; i < nums.length; i = i + 2) {
            if (nums[i] - nums[i - 1] <= num) {
                count++;
            }
        }
        return count;
    }

    public static long[] distanceOpt(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0L) + i);
        }
        Map<Integer, Integer> count = new HashMap<>();
        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            int curCount = count.getOrDefault(nums[i], 0);
            long sum = Math.abs((i * (long) curCount) - (map.get(nums[i]) - i));
            result[i] = sum;
            count.put(nums[i], curCount + 1);
        }
        return result;
    }

    public static long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            List<Integer> arr = map.get(nums[i]);
            long sum = 0;
            if (arr.size() > 1)
                for (int j = 0; j < arr.size(); j++) {
                    if (i != arr.get(j)) {
                        sum += Math.abs(i - arr.get(j));
                    }
                }
            result[i] = sum;
        }

        return result;
    }

    public static int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = nums[i][i];
            if (isPrime(nums[i][i])) {
                largest = Math.max(largest, cur);
            }
        }

        for (int i = 0; i < n; i++) {
            int cur = nums[i][nums.length - i - 1];
            if (isPrime(nums[i][nums.length - i - 1])) {
                largest = Math.max(largest, cur);
            }
        }

        return largest;
    }

    public static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
