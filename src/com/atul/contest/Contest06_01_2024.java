package com.atul.contest;

import java.util.*;

public class Contest06_01_2024 {
    public static void main(String[] args) {
    }

    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        Queue<Integer> apq = new LinkedList<>();
        //Queue<Integer> bpq = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n - Math.min(a.length(), b.length()) + 1; i++) {
            char ch = s.charAt(i);
            if (ch == a.charAt(0) && helper(s, a, i)) {
                apq.add(i);
            }
            if (ch == b.charAt(0) && helper(s, b, i)) {
                //bpq.add(i);
                set.add(i);
            }
        }

        //System.out.println(apq);
        //System.out.println(set);

        Set<Integer> result = new HashSet<>();
        while (!apq.isEmpty()) {
            int afirst = apq.poll();
            if (set.floor(afirst) != null) {
                int floor = set.floor(afirst);
                if (Math.abs(floor - afirst) <= k) {
                    result.add(afirst);
                }
            }
            ;
            if (set.ceiling(afirst) != null) {
                int ciel = set.ceiling(afirst);
                if (Math.abs(ciel - afirst) <= k) {
                    result.add(afirst);
                }
            }
        }
        List<Integer> finaResult = new ArrayList<>(result);
        Collections.sort(finaResult);
        return finaResult;
    }


    private static boolean helper(String s, String str, int index) {
        boolean flag = true;
        int idx = 0;
        int count = 0;
        if (index + str.length() <= s.length())
            for (int i = index; i < index + str.length(); i++) {
                count++;
                char sChar = s.charAt(i);
                char strChar = str.charAt(idx);
                idx++;
                if (sChar != strChar) {
                    flag = false;
                }
            }
        return flag && count == str.length();
    }


    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int it : nums) {
            map.put(it, map.getOrDefault(it, 0) + 1);
            max = Math.max(max, map.get(it));
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result += entry.getValue();
            }
        }
        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxAncestorDiff(TreeNode root) {
        int[] finalMax = new int[1];
        mainTrav(root, finalMax);
        return finalMax[0];
    }

    private static void mainTrav(TreeNode node, int[] finalMax) {
        if (node == null) {
            return;
        }
        //current Node
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        secTrav(node.left, node.val, max);
        secTrav(node.right, node.val, max);

        finalMax[0] = Math.max(finalMax[0], max[0]);
        mainTrav(node.left, finalMax);
        mainTrav(node.right, finalMax);
    }

    private static void secTrav(TreeNode node, int num, int[] max) {
        if (node == null) {
            return;
        }

        max[0] = Math.max(max[0], Math.abs(node.val - num));
        secTrav(node.left, num, max);
        secTrav(node.right, num, max);
    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double max = Integer.MIN_VALUE;
        int result = 0;
        for (int[] it : dimensions) {
            int a = it[0];
            int b = it[1];
            double dia = Math.sqrt((a * a) + (b * b));
            if (max == dia) {
                result = Math.max(result, a * b);
            } else if (max < dia) {
                max = dia;
                result = a * b;
            }
        }
        return result;
    }


    static class Tuple {
        int key;
        int val;

        public Tuple(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int num1 = n / 2;
        int num2 = n / 2;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int it : nums1) {
            map1.put(it, map1.getOrDefault(it, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int it : nums2) {
            map2.put(it, map2.getOrDefault(it, 0) + 1);
        }

        Queue<Tuple> pq1 = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            pq1.offer(new Tuple(entry.getKey(), entry.getValue()));
        }
        Queue<Tuple> pq2 = new PriorityQueue<>((a, b) -> b.val - a.val);
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            pq2.offer(new Tuple(entry.getKey(), entry.getValue()));
        }

        return 0;
    }


    static class Pair {
        int val;
        int num;

        public Pair(int val, int num) {
            this.val = val;
            this.num = num;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + val +
                    ", " + num +
                    '}';
        }

    }

    public static int minimumOperationsToMakeEqual(int x, int y) {
        Set<Integer> set = new HashSet<>();
        Queue<Pair> pq = new LinkedList<>();

        pq.offer(new Pair(x, 0));
        while (!pq.isEmpty()) {

            Pair temp = pq.poll();
            int val = temp.val;
            int res = temp.num;

            if (val == y) {
                return res;
            }

            if (!set.contains(val + 1)) {
                set.add(val + 1);
                pq.offer(new Pair(val + 1, res + 1));
            }

            if (val - 1 >= 0 && !set.contains(val - 1)) {
                set.add(val - 1);
                pq.offer(new Pair(val - 1, res + 1));
            }

            if (val % 5 == 0 && !set.contains(val / 5)) {
                set.add(val / 5);
                pq.offer(new Pair(val / 5, res + 1));
            }

            if (val % 11 == 0 && !set.contains(val / 11)) {
                set.add(val / 11);
                pq.offer(new Pair(val / 11, res + 1));
            }

            System.out.println(pq);

        }

        return -1;
    }

    public static int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int it : nums) {
            set.add(it);
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else break;
        }

        int num = sum;
        while (num < 50 * 50) {
            if (!set.contains(num)) {
                return num;
            }
            num++;
        }
        return -1;
    }
}
