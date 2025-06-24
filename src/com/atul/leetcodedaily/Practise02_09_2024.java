package com.atul.leetcodedaily;

import java.util.*;

public class Practise02_09_2024 {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        System.out.println(subarraySum1(nums, 0));
    }

    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            map.put(sum, i);
        }
        return result;
    }

    public static int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0) + 1);
        }

        System.out.println(maps);
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            int val = entry.getValue();
            if (isPrime(val)) {
                return true;
            }
        }
        return false;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }


    public static int minSwaps(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> even = new TreeMap<>();
        TreeMap<Integer, Integer> odd = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num % 2 == 0) {
                even.put(num, i);
            } else {
                odd.put(num, i);
            }
        }

        if (Math.abs(even.size() - odd.size()) > 1) {
            return -1;
        }
        if (odd.size() > even.size()) {
            Queue<Character> queue = new LinkedList<>();
            queue.add('O');
            queue.add('E');
            return solve(nums, queue, odd, even);
        } else {
            Queue<Character> queue = new LinkedList<>();
            queue.add('E');
            queue.add('O');
            return solve(nums, queue, odd, even);
        }
    }

    private static int solve(int[] nums, Queue<Character> queue, TreeMap<Integer, Integer> odd, TreeMap<Integer, Integer> even) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            char ch = queue.poll();
            if (ch == 'O') {
                //not odd case
                if (nums[i] % 2 == 0) {
                    Map.Entry<Integer, Integer> entry = odd.pollFirstEntry();
                    int num = entry.getKey();
                    int index = entry.getValue();
                    int temp = nums[i];
                    nums[i] = num;
                    nums[index] = temp;
                    result++;
                }
            } else {
                //not even case
                if (nums[i] % 2 != 0) {
                    Map.Entry<Integer, Integer> entry = even.pollFirstEntry();
                    int num = entry.getKey();
                    int index = entry.getValue();
                    int temp = nums[i];
                    nums[i] = num;
                    nums[index] = temp;
                    result++;
                }
            }
            queue.offer(ch);
        }
        return result;
    }

    static boolean findsum(int arr[]) {
        // Your code here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                return true;
            }

            map.put(sum, i);
        }

        return false;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (sum >= target) {
                    result = Math.min(result, i - left + 1);
                    sum -= nums[left++];
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] - min > k) {
                result += 1;
                min = nums[i];
            }
        }

        if (nums[n - 1] - min <= k) {
            result += 1;
        }
        return result;
    }

    public static int specialTriplets(int[] nums) {
        int mod = (int) Math.pow(10, 9) + 7;
        int n = nums.length;
        Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < n; i++) {
            right.put(nums[i], (right.getOrDefault(nums[i], 0) + 1));
        }


        long result = 0;
        Map<Integer, Integer> left = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (right.containsKey(nums[i]) && right.get(nums[i]) >= 1) {
                right.put(nums[i], right.get(nums[i]) - 1);
                if (right.get(nums[i]) <= 0) {
                    right.remove(nums[i]);
                }
            }

            int numberToFind = nums[i] * 2;
            if (left.containsKey(numberToFind)) {
                int first = left.get(numberToFind);
                int sec = -1;
                if (right.containsKey(numberToFind)) {
                    sec = right.get(numberToFind);
                }

                if (sec != -1) {
                    result = (int) (result + ((first * sec) % mod) % mod);
                }
            }

            left.put(nums[i], (left.getOrDefault(nums[i], 0) + 1));
        }
        return (int) result;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int colHalf = m / 2;
        int rowHalf = n / 2;

        //vert cut
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < colHalf; j++) {
                count += grid[i][j];
            }
        }


        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = colHalf; j < m; j++) {
                count2 += grid[i][j];
            }
        }

        //System.out.println(count+"<<>>"+count2);
        if (count == count2) return true;

        long count3 = 0;
        for (int i = 0; i < rowHalf; i++) {
            for (int j = 0; j < m; j++) {
                count3 += grid[i][j];
            }
        }
        long count4 = 0;
        for (int i = rowHalf; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count4 += grid[i][j];
            }
        }

        //System.out.println(count3+"<<>>"+count4);
        if (count3 == count4) {
            return true;
        }

        return false;
    }

    public static int minDeletion(String s, int k) {
        class Pair {
            char ch;
            int freq;

            public Pair(char ch, int freq) {
                this.ch = ch;
                this.freq = freq;
            }
        }

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if (map.size() <= k) {
            return 0;
        }
        System.out.println(map);

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (Map.Entry<Character, Integer> ent : map.entrySet()) {
            char ch = ent.getKey();
            int val = ent.getValue();
            pq.offer(new Pair(ch, val));
        }

        int count = 0;
        while (!pq.isEmpty() && pq.size() > k) {
            count += pq.poll().freq;
        }
        return count;
    }

    private static void fillQuad(Integer[][] nums, int row, int col, int cur) {
        if (row == nums.length && col == nums[0].length || nums[row][col] != null) return;

        nums[row][col] = cur;
        nums[row + 1][col] = cur - 1;
        nums[row + 1][col + 1] = cur - 1;
        nums[row][col + 1] = cur - 1;


        //fill top left quad
        fillQuad(nums, row, col, cur);

        //fill bottom  left quad
        fillQuad(nums, row + 2, col, cur - 4);

        //fill bottom right quad
        fillQuad(nums, row + 2, col + 2, cur - 4);

        //fill top right quad
        fillQuad(nums, row, col + 2, cur - 4);

    }


    public static boolean[] pathExistenceQueries11(int n, int[] nums, int maxDiff, int[][] queries) {
        Set<Integer> set = new HashSet<>();
        int right = 0;
        for (int i = 0; i < n - 1; i++) {
            while (right < n && nums[right] - nums[i] <= maxDiff) {
                right++;
            }
            for (int k = i + 1; k < right; k++) {
                int u = i;
                int v = k;
                set.add(u);
                set.add(v);
            }
        }
        boolean[] result = new boolean[queries.length];
        int index = 0;
        for (int[] it : queries) {
            int u = it[0];
            int v = it[1];
            if (set.contains(u) && set.contains(v)) {
                result[index++] = true;
            }
        }
        return result;
    }


    public int numTeams(List<Integer> coders) {
        int n = coders.size(), result = 0;
        if (n < 3) return 0;

        for (int i = 1; i < n - 1; i++) {
            int rightLess = 0, rightGreat = 0, leftLess = 0, leftGreat = 0;

            for (int j = 0; j < i; j++) {
                if (coders.get(j) < coders.get(i)) leftLess++;
                else leftGreat++;
            }

            for (int j = i + 1; j < n; j++) {
                if (coders.get(j) > coders.get(i)) rightGreat++;
                else rightLess++;
            }

            result += leftLess * rightGreat + leftGreat * rightLess;
        }

        return result;
    }

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int right = 0;
        for (int i = 0; i < n - 1; i++) {
            while (right < n && nums[right] - nums[i] <= maxDiff) {
                right++;
            }
            for (int k = i + 1; k < right; k++) {
                //result.add(Arrays.asList(i + 1, k + 1)); // 1-based indices
                int u = i;
                int v = k;

                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }

        boolean[] seen = new boolean[n];
        Map<Integer, Integer> map = new HashMap<>();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (seen[i] == false) {
                solve(graph, seen, i, map, cur);
                cur++;
            }
        }

        int m = queries.length;
        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] it = queries[i];
            int u = it[0];
            int v = it[1];
            if (Objects.equals(map.get(u), map.get(v))) {
                result[i] = true;
            }
        }
        return result;
    }

    private static void solve(List<List<Integer>> graph, boolean[] seen, int node, Map<
            Integer, Integer> component, int cur) {
        seen[node] = true;
        component.put(node, cur);
        for (int it : graph.get(node)) {
            if (seen[it] == false) {
                solve(graph, seen, it, component, cur);
            }
        }
    }

    //given an integer array nums of length n sorted in non-decreasing order, and an integer maxDiff. return all the pair of index i and j where the absolute difference between nums[i] and nums[j] is at most maxDiff (i.e., |nums[i] - nums[j]| <= maxDiff).

    public static int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;
        Map<Integer, TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cols = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] nums = buildings[i];
            int u = nums[0];
            int v = nums[1];

            rows.putIfAbsent(u, new TreeSet<>());
            rows.get(u).add(v);

            cols.putIfAbsent(v, new TreeSet<>());
            cols.get(v).add(u);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int[] nums = buildings[i];
            int u = nums[0];
            int v = nums[1];
            if (rowCheck(rows, u, v) && colCheck(cols, u, v)) {
                count++;
            }
        }
        return count;
    }

    private static boolean rowCheck(Map<Integer, TreeSet<Integer>> map, int row, int col) {
        map.get(row).remove(col);
        if (map.get(row).floor(col) != null && map.get(row).ceiling(col) != null) {
            map.get(row).add(col);
            return true;
        }

        map.get(row).add(col);
        return false;
    }

    private static boolean colCheck(Map<Integer, TreeSet<Integer>> map, int row, int col) {
        map.get(col).remove(row);
        if (map.get(col).floor(row) != null && map.get(col).ceiling(row) != null) {
            map.get(col).add(row);
            return true;
        }
        map.get(col).add(row);
        return false;
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int suff = 1;
        int pref = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            suff *= nums[i];
            pref *= nums[n - i - 1];
            max = Math.max(max, Math.max(suff, pref));

            if (suff == 0) suff = 1;
            if (pref == 0) pref = 1;
        }
        return max;
    }


    public static long calculateScore(String[] instructions, int[] values) {
        int n = instructions.length;
        int index = 0;
        long result = 0;
        Set<Integer> set = new HashSet<>();
        while (index >= 0 && index < n) {
            String str = instructions[index];
            if (!set.contains(index)) {
                set.add(index);
                if (str.equals("add")) {
                    result += values[index];
                    index++;
                } else {
                    index += values[index];
                }
            } else {
                break;
            }
        }
        return result;
    }

    public static int maxProduct12(int[] nums) {
        int n = nums.length;
        int multTillNow = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            multTillNow *= nums[i];
            if (nums[i] > multTillNow) {
                max = Math.max(nums[i], max);
                multTillNow = nums[i];
            } else {
                max = Math.max(max, multTillNow);
            }
        }
        return max;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curCount = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) curCount++;
            if (map.containsKey(curCount - goal)) {
                result += map.get(curCount);
            }
            map.put(curCount, map.getOrDefault(curCount, 0) + 1);
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minTillNow = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            minTillNow = Math.min(minTillNow, prices[i]);
            max = Math.max(max, prices[i] - minTillNow);
        }
        return max;
    }

    private static int solveKad(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (nums[i] > sum) {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        max = Math.max(max, sum);
        return max;
    }

    //Shortest Subarray with Sum at Least K

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        long sum = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum >= k) {
                min = Math.min(min, i - left + 1);
                while (sum >= k) {
                    min = Math.min(min, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
        }
        return min == 0 ? -1 : min;
    }

    public static int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] prefix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    prefix[i][j] = ((grid[i][j] % 12345) * (i - 1 >= 0 ? prefix[i - 1][m - 1] : 1)) % 12345;
                } else {
                    prefix[i][j] = ((grid[i][j] % 12345) * (prefix[i][j - 1])) % 12345;
                }
            }
        }
        int[][] suff = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    suff[i][j] = ((grid[i][j] % 12345) * (i + 1 < n ? suff[i + 1][0] : 1)) % 12345;
                } else {
                    suff[i][j] = ((grid[i][j] % 12345) * (suff[i][j + 1])) % 12345;
                }
            }
        }

        System.out.println(Arrays.deepToString(prefix));
        System.out.println(Arrays.deepToString(suff));

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    result[i][j] = ((j + 1 < m ? suff[i][j + 1] : (i + 1 < n ? suff[i + 1][j] : 1)) * (i - 1 >= 0 ? prefix[i - 1][m - 1] : 1)) % 12345;
                } else if (j == m - 1) {
                    result[i][j] = (prefix[i][j - 1] * (i + 1 < n ? suff[i + 1][0] : 1)) % 12345;
                } else {
                    result[i][j] = (prefix[i][j - 1] * suff[i][j + 1]) % 12345;
                }
            }
        }
        return result;
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                arr[i] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        return 0;
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = grid[i][j] + (j - 1 >= 0 ? nums[i][j - 1] : 0) + (i - 1 >= 0 ? nums[i - 1][j] : 0) - (j - 1 >= 0 && i - 1 >= 0 ? nums[i - 1][j - 1] : 0);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int sum = 1;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (zeroCount == nums[i]) {
                zeroCount++;
            }
            sum *= nums[i];
            prefix[i] = sum;
        }

        if (zeroCount > 1) {
            return new int[n];
        } else {
            int[] suff = new int[n];
            for (int i = n - 1; i >= 0; i++) {

            }
        }
        return new int[]{};
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                count++;
            }

            if (count >= k) {
                result++;
                int index = 0;
                while (true) {
                    if (nums[index] % 2 != 0) {
                        count--;
                        if (count < k) {
                            count++;
                            break;
                        }
                    }
                    index++;
                    result++;
                }
            }
        }
        return result;
    }

    static class NumMatrix {

        int[][] nums;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            nums = new int[n][m];

            for (int col = 0; col < m; col++) {
                for (int row = 0; row < n; row++) {
                    nums[row][col] = matrix[row][col] + (row - 1 >= 0 ? nums[row - 1][col] : 0);
                }
            }

            // System.out.println(Arrays.deepToString(nums));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = matrix[i][j] + (j - 1 >= 0 ? nums[i][j - 1] : 0) + (i - 1 >= 0 ? nums[i - 1][j] : 0) - (i - 1 >= 0 && j - 1 >= 0 ? nums[i - 1][j - 1] : 0);
                }
            }

            System.out.println(Arrays.deepToString(nums));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int fin = nums[row2][col2] - (col1 - 1 >= 0 ? nums[row2][col1 - 1] : 0) - (row1 - 1 >= 0 ? nums[row1 - 1][col2] : 0) + (col1 - 1 >= 0 && row1 - 1 >= 0 ? nums[row1 - 1][col1 - 1] : 0);
            return fin;
        }
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            totalSum += nums[i];
        }

        int sumFromLeft = 0;
        for (int i = 0; i < n; i++) {
            sumFromLeft += nums[i];
            int sumFromRight = totalSum - sumFromLeft;
            int sumFromLeftNoIncludingCurrent = sumFromLeft - nums[i];
            if (sumFromRight == sumFromLeftNoIncludingCurrent) {
                return i;
            }
        }
        return -1;
    }
}
