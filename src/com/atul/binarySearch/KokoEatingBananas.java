package com.atul.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class KokoEatingBananas {
    public static void main(String[] args) {
        char str = (char) (1 + 'a');
        System.out.println(str);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        String result = "";
        solve(root, result, "");
        return result;
    }

    private static void solve(TreeNode root, String result, String str) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            str += (char) (root.val + 'a');
            if (result.isEmpty()) {
                result = str;
            } else {
                int num = result.compareTo(str);
                System.out.println(result.toString() + "result");
                System.out.println("formed " + str);
                if (num < 0) {
                    result = str;
                }
            }

        }

        solve(root.left, result, str + (char) (root.val + 'a'));
        solve(root.right, result, str + (char) (root.val + 'a'));
    }

    public int sumNumbers(TreeNode root) {
        int[] num = new int[1];
        solve(root, num, "");
        return num[0];
    }

    private static void solve(TreeNode root, int[] list, String str) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            str += root.val;
            list[0] += Integer.valueOf(str);
            return;
        }

        solve(root.left, list, str + root.val);
        solve(root.right, list, str + root.val);
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String str = words[i];
            int len = str.length();
            if (check(str.charAt(0)) && check(str.charAt(len - 1))) {
                count++;
            }
        }
        return count;
    }

    private static boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }


    public static int maxScore(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) count++;
        }
        return (int) count;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp.next != null) {
            set.add(temp);
            ListNode ret = temp;
            temp = temp.next;
            if (set.contains(temp)) {
                return temp;
            }

        }
        return null;
    }


    public int minEatingSpeed(int[] nums, int h) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }

        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (solve(sum, mid, h)/*check(nums, mid, h)*/) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static boolean solve(long sum, int k, int given) {
        int div = (int) sum / k;
        return div <= given;
    }

    private static boolean check(int[] nums, int k, int given) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num < k) {
                count++;
                continue;
            } else {
                while (num > 0) {
                    count++;
                    num -= k;
                }
            }
        }

        if (count <= given) return true;
        return false;
    }
}
