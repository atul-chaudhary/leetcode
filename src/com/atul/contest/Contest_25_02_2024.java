package com.atul.contest;

import java.util.*;

public class Contest_25_02_2024 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 8};
        System.out.println(Arrays.toString(resultArray(nums)));
    }

    public static int[] resultArray(int[] nums) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        int n = nums.length;
        nums1.add(nums[0]);
        nums2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (nums1.get(nums1.size() - 1) > nums2.get(nums2.size() - 1)) {
                nums1.add(nums[i]);
            } else {
                nums2.add(nums[i]);
            }
        }
        for (int i = 0; i < nums1.size(); i++) {
            nums[i] = nums1.get(i);
        }
        int index = nums1.size();
        for (int it : nums2) {
            nums[index++] = it;
        }
        return nums;
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] pref = new int[n][m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    sum += grid[i][j];
                    pref[i][j] = sum;
                } else {
                    sum += grid[i][j];
                    sum += pref[i - 1][j];
                    if (j > 0)
                        sum -= pref[i - 1][j - 1];
                    pref[i][j] = sum;
                }
            }
            sum = 0;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pref[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Pair {
        int num;
        int val;

        public Pair(int num, int val) {
            this.num = num;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "num=" + num +
                    ", val=" + val +
                    '}';
        }
    }

    public static int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int center = n / 2;
        int[] yPart = new int[3];
        int[] nonYPart = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < center && i == j) || (i < center && j == (n - i - 1)) || (i >= center && j == center)) {
                    if (grid[i][j] == 0) {
                        yPart[0]++;
                    }
                    if (grid[i][j] == 1) {
                        yPart[1]++;
                    }
                    if (grid[i][j] == 2) {
                        yPart[2]++;
                    }
                } else {
                    if (grid[i][j] == 0) {
                        nonYPart[0]++;
                    }
                    if (grid[i][j] == 1) {
                        nonYPart[1]++;
                    }
                    if (grid[i][j] == 2) {
                        nonYPart[2]++;
                    }
                }
            }
        }

        List<Pair> yList = new ArrayList<>();
        yList.add(new Pair(0, yPart[0]));
        yList.add(new Pair(1, yPart[1]));
        yList.add(new Pair(2, yPart[2]));
        Collections.sort(yList, (a, b) -> b.val - a.val);


        List<Pair> non = new ArrayList<>();
        non.add(new Pair(0, nonYPart[0]));
        non.add(new Pair(1, nonYPart[1]));
        non.add(new Pair(2, nonYPart[2]));
        Collections.sort(non, (a, b) -> b.val - a.val);

        System.out.println(yList);
        System.out.println(non);

        if (yList.get(0).num == non.get(0).num) {
            //1 condition
            int yP1 = solve(yPart) - (yList.get(1).val);
            int p1 = solve(nonYPart) - (non.get(0).val);
            int first = yP1 + p1;

            //2 condition
            int yP2 = solve(yPart) - (yList.get(0).val);
            int p2 = solve(nonYPart) - (non.get(1).val);
            int sec = yP2 + p2;

            return Math.min(first, sec);
        }
        int yP = solve(yPart) - (yList.get(0).val);
        int p = solve(nonYPart) - (non.get(0).val);
        return yP + p;
    }

    private static int solve(int[] num) {
        int sum = 0;
        for (int it : num) {
            sum += it;
        }
        return sum;
    }


    public static int minOperations2(int[] nums, int k) {
        Queue<Long> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.offer((long) it);
        }

        int count = 0;
        while (pq.size() >= 2) {
            long first = pq.poll();
            long second = pq.poll();
            if (first >= k) {
                break;
            }
            long cal = Math.min(first, second) * 2 + Math.max(first, second);
            pq.offer(cal);
            count++;
        }
        return count;
    }

    public static int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        System.out.println(Arrays.toString(nums));
        for (int it : nums) {
            if (it >= k) {
                break;
            }
            count++;
        }
        return count;
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long result = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rx1 = bottomLeft[i][0];
                int ry1 = bottomLeft[i][1];
                int rx2 = topRight[i][0];
                int ry2 = topRight[i][1];

                int x1 = bottomLeft[j][0];
                int y1 = bottomLeft[j][1];
                int x2 = topRight[j][0];
                int y2 = topRight[j][1];

                if (rx1 <= x1 && rx2 >= x1 && y1 >= ry1 && y1 <= ry2) {
                    if (rx1 <= x2 && rx2 >= x2 && y2 >= ry1 && y2 <= ry2) {
                        long side = x2 - x1;
                        long side2 = y2 - y1;
                        if (side == side2)
                            result = Math.max(result, side);
                    } else {
                        long side1 = (rx2 - x1);
                        long side = (ry2 - y1);
                        if (side == side1) {
                            result = Math.max(result, side);
                        }
                    }
                }
            }
        }
        return result;
    }


    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 2) {
                return false;
            }
        }
        return true;
    }
}
