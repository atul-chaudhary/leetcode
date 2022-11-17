package com.atul.greedy;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {

        Integer[] arr = {7, 6, 8, 5};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(swaps(list));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int count = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                temp.add(node.val);
                if (node.left != null) {
                    pq.offer(node.left);
                }

                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            count += swaps(temp);
        }
        return count ;
    }

    private static int swaps(List<Integer> list) {
        System.out.println(list);
        int n = list.size();
        int swap = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = list.get(i);
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != arr[i][1]) {
                while (i != arr[i][1]) {
                    int[] temp = arr[i];
                    arr[i] = arr[temp[1]];
                    arr[temp[1]] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarrayLCM(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int lcm = nums[i];
            if (lcm == k) count++;
            for (int j = i + 1; j < n; j++) {
                int gcd = findGCD(nums[j], lcm);
                lcm = (lcm * nums[j]) / gcd;
                if (lcm > k) break;
                if (lcm == k) count++;
            }
        }
        return count;
    }

    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public static double[] convertTemperature(double celsius) {
        double Kelvin = celsius + 273.15;
        double Fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{Kelvin, Fahrenheit};
    }

    public static int distinctAverages(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(treeMap);
        HashSet<Double> set = new HashSet<>();
        while (!treeMap.isEmpty()) {
            Map.Entry<Integer, Integer> first = treeMap.firstEntry();
            Map.Entry<Integer, Integer> last = treeMap.lastEntry();
            set.add((first.getKey() + last.getKey() + 0.0) / 2);

            if (first.getValue() > 1) {
                treeMap.put(first.getKey(), first.getValue() - 1);
            } else treeMap.pollFirstEntry();

            if (last.getValue() > 1) {
                treeMap.put(last.getKey(), last.getValue() - 1);
            } else treeMap.pollLastEntry();
        }
        return set.size();
    }

    public static int findMinArrowShotsopt(int[][] nums) {

        int n = nums.length;
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        for (int[] row : nums) System.out.println(Arrays.toString(row));
        int arrow = 1;
        long endPoint = nums[0][1];
        for (int i = 1; i < n; i++) {
            long num = nums[i][0];
            if (num > endPoint) {
                arrow++;
                endPoint = nums[i][1];
            }
        }
        return arrow;
    }

    public static int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] row : points) System.out.println(Arrays.toString(row));
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }

    public static int findMinArrowShots(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] row : nums) System.out.println(Arrays.toString(row));
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nums[0][1]);
        int count = 1;
        for (int i = 1; i < n; i++) {
            int num = pq.peek();
            if (nums[i][0] >= num) {
                pq.poll();
                pq.add(nums[i][1]);
            } else {
                count++;
                pq.add(nums[i][1]);
            }
        }
        return count;
    }
}
