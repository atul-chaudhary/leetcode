package com.atul.contest;

import java.util.*;

public class Contest05_03_2023 {
    public static void main(String[] args) {
        int[][] nums = {{50, 1}, {50, 2}, {50, 5}};
        System.out.println(waysToReachTargetopt(5, nums));
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        int count = 0;
        for (int i = 1; i < 1000; i++) {
            if(!set.contains(arr[i])){
                count++;
                if(count == k){
                    return i;
                }
            }
        }
        return -1;
    }

    static int mod = (int) 1e9 + 7;

    public static int waysToReachTargetopt(int target, int[][] types) {
        List<Integer> nums = new ArrayList<>();
        int n = types.length;
        for (int i = 0; i < n; i++) {
            int count = types[i][0];
            int marks = types[i][1];
            for (int j = 0; j < count; j++) {
                nums.add(marks);
            }
        }

        System.out.println(nums);
        Integer[][] dp = new Integer[nums.size()][1001];
        return solve(nums, 0, target, 0, dp);
    }

    private static int solve(List<Integer> nums, int index, int target, int cur, Integer[][] dp) {
        if (cur > target) {
            return 0;
        }
        if (index >= nums.size()) {
            if (cur == target) {
                return 1;
            }
            return 0;
        }

        if (dp[index][cur] != null) return dp[index][cur];

        int pick = solve(nums, index + 1, target, cur + nums.get(index), dp) % mod;
        int notPick = solve(nums, index + 1, target, cur, dp) % mod;

        return dp[index][cur] = (pick + notPick) % mod;
    }

    public static int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int counti = types[i - 1][0];
            int marksi = types[i - 1][1];

            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= counti && j - k * marksi >= 0; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * marksi]) % MOD;
                }
            }
        }

        return dp[n][target];
    }


    public static int findValidSplit(int[] nums) {
        int n = nums.length;
        long[] pref = new long[n];
        pref[0] = nums[0];

        long[] gcdPref = new long[n];
        for (int i = 1; i < n - 1; i++) {
            pref[i] = pref[i - 1] * nums[i];
            gcdPref[i] = gcd(nums[i - 1], nums[i]);
        }
        long[] suff = new long[n];
        suff[n - 1] = nums[n - 1];
        long[] gcdSuff = new long[n];
        for (int i = n - 2; i >= 1; i--) {
            suff[i] = suff[i + 1] * nums[i];
            gcdSuff[i] = gcd(nums[i], nums[i + 1]);
        }
        System.out.println(Arrays.toString(gcdSuff));
        System.out.println();
        System.out.println(Arrays.toString(pref));
        System.out.println(Arrays.toString(suff));

        for (int i = 0; i < n - 1; i++) {
            if (gcd(pref[i], suff[i + 1]) == 1) {
                return i;
            }
        }
        return -1;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        Queue<Long> result = new PriorityQueue<>(Collections.reverseOrder());
        while (!pq.isEmpty()) {
            int size = pq.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                sum += node.val;
                if (node.left != null) {
                    pq.offer(node.left);
                }

                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            result.add(sum);
        }
        System.out.println(result);
        long num = -1;
        while (k > 0 && !result.isEmpty()) {
            num = result.poll();
            k--;
        }
        return k == 0 ? num : -1;
    }

    public static int passThePillow(int n, int time) {
        int index = 1;
        boolean flag = true;
        while (time-- > 0) {
            if (index < n && flag) {
                index++;
            } else if (!flag) {
                index--;
            }

            if (index == 1) {
                flag = true;
            } else if (index == n) {
                flag = false;
            }
        }
        return index;
    }
}
