package com.atul.contest;

import java.util.*;

public class Contest_13_05_2023 {
    public static void main(String[] args) {
        int[] nums = {5,1,4,3};
        System.out.println(solutionOpt(nums));
    }
    public static int solutionOpt(int[] A) {
        // Implement your solution here
        int n = A.length;
        Map<Integer, Integer> occ1 = new HashMap<>();
        Map<Integer, Integer> occ2 = new HashMap<>();
        int[] preSums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                preSums[i] = preSums[i - 1] + A[i];
            } else {
                preSums[i] = A[i];
            }
            if (!occ1.containsKey(A[i])) {
                occ1.put(A[i], i);
            }
            occ2.put(A[i], i);
        }
        int result = -1;
        for (int i = 0; i < n; i++) {
            int start = occ1.get(A[i]);
            int end = occ2.get(A[i]);
            if(start == end) continue;
            int sum = 0;
            if (start == 0)
                sum = preSums[end];
            else
                sum = preSums[end] - preSums[start - 1];
            if (sum > result)
                result = sum;
        }

        return result;
    }

    public int solveOpt(int[] a) {
        int n = a.length;
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {

            if (i != 0) {
                prefix[i] = prefix[i - 1] + a[i];
            } else {
                prefix[i] = a[i];
            }
            if (!first.containsKey(a[i])) {
                first.put(a[i], i);
            }

            last.put(a[i], i);
        }

        int ans = -1;

        // Find the maximum sum with same first and last
        // value
        for (int i = 0; i < n; i++) {
            int start = first.get(a[i]);
            int end = last.get(a[i]);
            int sum = 0;
            if (start == 0)
                sum = prefix[end];
            else
                sum = prefix[end] - prefix[start - 1];
            if (sum > ans)
                ans = sum;
        }

        return ans;
    }

    public static int solution(int[][] A) {
        // Implement your solution here
        int n = A.length;
        int m = A[0].length;
        int count = 0;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(A[i][j], new HashSet<>());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.get(A[i][j]).add(i);
            }
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            int val = entry.getValue().size();
            if (val > 1) {
                count++;
            }
        }
        return count;
    }

    public static int solution(String S) {
        // Implement your solution here
        int n = S.length();
        StringBuilder sb = new StringBuilder(S);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(0) == sb.charAt(n - 1)) {
                count++;
            }
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
        }
        return count;
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
            max = Math.max(max, A[i]);
        }

        if (max < 0) return 1;
        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(nums[i]);
        }
        int col = m;
        int sum = 0;
        while (col > 0) {
            int cur = col - 1;
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = nums[i][cur];
                temp = Math.max(temp, num);
            }
            sum += temp;
            col--;
        }
        return sum;
    }

    public static int countSeniors(String[] details) {
        int n = details.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int age = Integer.parseInt(details[i].substring(11, 13));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }

    public static int sumOfPower(int[] nums) {
        max = nums[0];
        min = nums[0];
        return solve(nums, 0);
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int mod = (int) 1e9 + 7;

    private static int solve(int[] nums, int index) {
        if (index >= nums.length) {
            System.out.println(max + "<<>>" + min);
            max = nums[0];
            min = nums[0];
            return 0;
        }

        int cal = ((((int) Math.pow(Math.max(max, nums[index]), 2)) % mod) * Math.min(min, nums[index])) % mod;
        int pick = (cal + solve(nums, index + 1)) % mod;
        int notPick = solve(nums, index + 1) % mod;

        return (pick + notPick) % mod;
    }
}
