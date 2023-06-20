package com.atul.contest;


import java.util.*;

public class Contest18_06_2023 {
    public static void main(String[] args) {
        System.out.println(solve(24, 16));
    }

    public static int lenOfLongSubarr(int A[], int N, int K) {
        //Complete the function
        int count = 0;
        int sum = 0;
        int ans = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            count++;
            sum += A[i];
            if (sum == K) {
                ans = Math.max(ans, count);
            }
            while (sum > K) {
                count--;
                sum -= A[index++];
            }
        }
        return ans;
    }


    public static int solve(int X, int Y) {
        if (X == Y) {
            return 0;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new Pair(X, 0));
        visited.add(X);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentNum = current.getNumber();
            int steps = current.getSteps();

            // Multiply by 2 operation
            int nextNum = currentNum * 2;
            if (nextNum == Y) {
                return steps + 1;
            } else if (nextNum < Y && !visited.contains(nextNum)) {
                queue.offer(new Pair(nextNum, steps + 1));
                visited.add(nextNum);
            }

            // Divide by 2 operation
            if (currentNum % 2 == 0) {
                nextNum = currentNum / 2;
                if (nextNum == Y) {
                    return steps + 1;
                } else if (!visited.contains(nextNum)) {
                    queue.offer(new Pair(nextNum, steps + 1));
                    visited.add(nextNum);
                }
            }
        }

        return -1;
    }

    static class Pair {
        private int number;
        private int steps;

        public Pair(int number, int steps) {
            this.number = number;
            this.steps = steps;
        }

        public int getNumber() {
            return number;
        }

        public int getSteps() {
            return steps;
        }
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (count == k) {
                count--;
                int max = map.lastKey();
                result.add(max);
                int item = arr[i - k + 1];
                map.put(item, map.get(item) - 1);
                if (map.get(item) == 0) {
                    map.remove(item);
                }
            }
        }
        return result;
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        int count = 0;
        Queue<Long> pq = new LinkedList<>();
        long[] result = new long[N - K + 1];
        int index = 0;
        for (int i = 0; i < N; i++) {
            count++;
            if (A[i] < 0) {
                pq.offer(A[i]);
            }
            if (count == K) {
                count--;
                if (pq.isEmpty()) {
                    result[index++] = 0;
                } else {
                    result[index++] = pq.peek();
                }

                long item = A[i - K + 1];
                if (!pq.isEmpty() && pq.peek() == item) {
                    pq.poll();
                }
            }
        }

        return result;
    }

    static long maximumSumSubarray(int k, List<Integer> Arr, int n) {
        int count = 0;
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += Arr.get(i);
            count++;

            if (count == k) {
                count--;
                max = Math.max(max, sum);
                sum -= Arr.get(i - k + 1);
            }
        }
        return max;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            System.out.println(Arrays.toString(dp));
            int cur = largestRectangleArea(dp);
            System.out.println(cur);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 1) return heights[0];
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(n - 1);
        nsr[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = -1;
            } else {
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        nsl[0] = -1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }
        //System.out.println(Arrays.toString(nsr));
        //System.out.println(Arrays.toString(nsl));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int nssr = nsr[i] == -1 ? n : nsr[i];
            int nssl = nsl[i];
            int cur = heights[i] * (nssr - nssl - 1);
            max = Math.max(max, cur);
        }

        return max;
    }

    public static int[] calculateSpan(int[] price, int n) {
        int[] ngl = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ngl[0] = -1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ngl[i] = -1;
            } else {
                ngl[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = ngl[i] == -1 ? i + 1 : i - ngl[i];
        }
        return result;
    }

    public static int[] ngl(int[] nums) {
        int n = nums.length;
        int[] ngl = new int[n];
        Stack<Integer> stack = new Stack<>();
        ngl[0] = -1;
        stack.push(nums[0]);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                ngl[i] = -1;
            } else {
                ngl[i] = stack.peek();
            }
            stack.push(nums[i]);
        }

        return ngl;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] ngr = new int[n];
        ngr[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ngr[i] = -1;
            } else {
                ngr[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        int len = nums1.length;
        int[] result = new int[len];
        for (int i = 0; i < n; i++) {
            result[i] = ngr[map.get(nums1[i])];
        }
        return result;
    }

    public static int paintWalls(int[] cost, int[] time) {
        Integer[][] dp = new Integer[501][501];
        return solve(cost, time, 0, cost.length, dp);
    }

    private static int solve(int[] cost, int[] time, int index, int wall, Integer[][] dp) {
        if (index >= cost.length) {
            return (int) 1e9;
        }

        if (wall <= 0) {
            return 0;
        }
        if (dp[index][wall] != null) return dp[index][wall];

        int pick = cost[index] + solve(cost, time, index + 1, wall - time[index] - 1, dp);
        int notPick = solve(cost, time, index + 1, wall, dp);

        return dp[index][wall] = Math.min(pick, notPick);

    }

    public static int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 1; i--) {
            min = Math.min(min, Math.abs(nums[i] - nums[i - 1]));
        }
        return min;
    }

    public static int distanceTraveled(int mainTank, int additionalTank) {
        int result = 0;
        int count = 0;
        for (int i = 1; i <= mainTank; i++) {
            count++;
            result += 10;
            if (count == 5) {
                if (additionalTank >= 1) {
                    mainTank += 1;
                    additionalTank -= 1;
                }
                count = 0;
            }
        }
        return result;
    }
}
