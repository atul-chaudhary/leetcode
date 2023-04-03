package com.atul.contest;

import java.util.*;

public class Contest02_04_2023 {
    public static void main(String[] args) {
        int[] r1 = {1, 1, 3, 4};
        int[] r2 = {4, 4, 1, 1};
        System.out.println(miceAndCheese(r1, r2, 2));
    }

    static class Tuple {
        int diff;
        int index;

        public Tuple(int diff, int index) {
            this.diff = diff;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "diff=" + diff +
                    ", index=" + index +
                    '}';
        }
    }

    public static int miceAndCheese(int[] r1, int[] r2, int k) {
        int n = r1.length;
        int sum = 0;
        for (int it : r2) {
            sum += it;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(r1[i] - r2[i]);
        }

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    static class Pair {
        int val;
        int fre;

        public Pair(int val, int fre) {
            this.val = val;
            this.fre = fre;
        }
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> b.fre - a.fre);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            max = Math.max(max, entry.getValue());
        }
        List<Set<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            arr.add(new HashSet<>());
        }
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int num = pair.val;
            int fre = pair.fre;
            int index = 0;
            while (fre > 0) {
                if (index < arr.size() && arr.get(index).contains(num)) {
                    index++;
                } else {
                    arr.get(index).add(num);
                    fre--;
                }
            }
        }

        int size = arr.size();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Set<Integer> set = arr.get(i);
            result.add(new ArrayList<>(set));
        }
        return result;
    }

    public static int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int longest = 0;
        int zero = 0;
        int one = 0;
        Character prev = null;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (prev == null && ch == '0') {
                zero++;
            } else if (prev == null && ch == '1') {
                one++;
            } else if (prev == '0' && ch == '0') {
                zero++;
            } else if (prev == '0' && ch == '1') {
                one++;
            } else if (prev == '1' && ch == '1') {
                one++;
            } else if (prev == '1' && ch == '0') {
                longest = Math.max(longest, Math.min(zero, one));
                zero = 0;
                one = 0;
                zero++;
            }
            prev = ch;
        }
        longest = Math.max(longest, Math.min(zero, one));
        return longest * 2;
    }

}
