package com.atul.contest;

import java.util.*;

public class Contest_21_01_2024 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(modifiedMatrix(nums)));
    }



    public static int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] nums = new int[m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            nums[index++] = max;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = nums[j];
                }
            }
        }
        return matrix;
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int m = pattern.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    list.add(nums[k]);
                }
                if (list.size() < m + 1) continue;
                if (list.size() == m + 1 && helper(list, pattern)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean helper(List<Integer> arr, int[] pattern) {
        System.out.println(arr);
        int m = pattern.length;
        boolean flag = true;
        for (int k = 0; k < m; k++) {
            if (pattern[k] == 1 && arr.get(k + 1) <= arr.get(k)) {
                flag = false;
            } else if (pattern[k] == 0 && !Objects.equals(arr.get(k + 1), arr.get(k))) {
                flag = false;
            } else if (pattern[k] == -1 && arr.get(k + 1) >= arr.get(k)) {
                flag = false;
            }
            if (flag == false) {
                return false;
            }
        }
        return flag;
    }

    public static String triangleType(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int it : nums) {
            set.add(it);
        }
        if (set.size() == 1 && helper(nums)) return "equilateral";
        else if (set.size() == 2 && helper(nums)) return "isosceles";
        else if (set.size() == 3 && helper(nums)) return "scalene";
        return "none";
    }

    private static boolean helper(int[] nums) {
        if (nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[1] + nums[2] > nums[0]) {
            return true;
        }
        return false;
    }

    public static int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int curr = 0;
        for (int it : nums) {
            if (it > 0) {
                curr += it;
            } else {
                curr -= Math.abs(it);
            }
            if (curr == 0) {
                count++;
            }
        }
        return count == 0 ? -1 : count;
    }

    public static int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int count = 0;
        boolean flag = true;
        for (int i = k; i < n; i = i + k) {
            count++;
            boolean result = helper(word, i, word);
            if (result) {
                flag = false;
                return count;
            }
        }
        if (flag) {
            return n / k;
        }
        return count;
    }

    private static boolean helper(String word, int idx, String init) {
        boolean flag = true;
        int n = word.length();
        int index = 0;
        for (int i = idx; i < n; i++) {
            if (init.charAt(index++) != word.charAt(i)) {
                flag = false;
            }
        }
        return flag;
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int o = s3.length();

        int count1 = 0;
        int index = 0;
        while (index < n && index < m && index < o) {
            char ch1 = s1.charAt(index);
            char ch2 = s2.charAt(index);
            char ch3 = s3.charAt(index);
            if (ch1 == ch2 && ch2 == ch3) {
                index++;
            } else break;
        }
        if (index == 0) {
            return -1;
        }
        return (n - index) + (m - index) + (o - index);
    }

    public static int countKeyChanges(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (String.valueOf(s.charAt(i)).toLowerCase().equals(String.valueOf(s.charAt(i - 1)).toLowerCase())) {
                continue;
            }
            count++;
        }
        return count;
    }

    static class Pair {
        int val;
        char chl;

        public Pair(int val, char chl) {
            this.val = val;
            this.chl = chl;
        }
    }

    public int minimumPushes(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int lst = entry.getValue();
            pairs.add(new Pair(lst, ch));
        }
        Collections.sort(pairs, (a, b) -> b.val - a.val);
        Map<Integer, List<Character>> formed = new HashMap<>();
        Map<Character, Integer> charMapping = new HashMap<>();

        Queue<Integer> pq = new LinkedList<>();
        pq.addAll(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));

        for (Pair it : pairs) {
            int key = it.val;
            char ch = it.chl;
            formed.putIfAbsent(key, new ArrayList<>());

            if (charMapping.containsKey(ch)) {
                int existingNum = charMapping.get(ch);
                formed.get(existingNum).add(ch);
            } else {
                int num = pq.poll();
                pq.offer(num);

            }
        }
        return 0;
    }


}