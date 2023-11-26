package com.atul.contest;

import java.util.List;
import java.util.PriorityQueue;
import java.util.*;

public class Contest29_10_2023 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char cur = s1.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        Map<Character, Integer> temp = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            char cur = s2.charAt(i);
            temp.put(cur, temp.getOrDefault(cur, 0) + 1);
            count++;
            if (count == n) {
                if (check(map, temp)) return true;
                char prev = s2.charAt(i - n + 1);
                temp.put(prev, temp.get(prev) - 1);
                if (temp.get(prev) == 0) {
                    temp.remove(prev);
                }
                count--;
            }
        }
        return false;
    }

    private static boolean check(Map<Character, Integer> org, Map<Character, Integer> der) {
//        System.out.println(org);
//        System.out.println(der);
//        System.out.println();
        for (Map.Entry<Character, Integer> entry : org.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (!der.containsKey(key)) return false;
            if (der.get(key) != val) {
                return false;
            }
        }
        return true;
    }

    public static int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            right.put(ch, right.getOrDefault(ch, 0) + 1);
        }

        Set<String> set = new HashSet<>();
        char fir = s.charAt(0);
        left.put(fir, left.getOrDefault(fir, 0) + 1);
        right.put(fir, right.get(fir) - 1);
        if (right.get(fir) == 0) {
            right.remove(fir);
        }

        for (int i = 1; i < n - 1; i++) {
            char cur = s.charAt(i);
            if (right.containsKey(cur)) {
                right.put(cur, right.get(cur) - 1);
                if (right.get(cur) == 0) {
                    right.remove(cur);
                }
            }

            System.out.println(left + " " + i);
            System.out.println(right + " " + i);
            System.out.println();
            for (int j = 0; j <= 25; j++) {
                StringBuilder formed = new StringBuilder();
                char correct = (char) (j + 'a');
                if (left.containsKey(correct) && right.containsKey(correct)) {
                    formed.append(correct).append(cur).append(correct);
                    set.add(formed.toString());
                    System.out.println(formed + "<<>>");
                }
            }
            left.put(cur, left.getOrDefault(cur, 0) + 1);
        }
        return set.size();
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int first = nums1[n - 1];
        int second = nums2[n - 1];
        Nope firstCheck = checkFirst(nums1, nums2, first, second);
        Nope secondCheck = checkFirst(nums1, nums2, second, first);
        secondCheck.count++;
        if (firstCheck.check && secondCheck.check) {
            return Math.min(firstCheck.count, secondCheck.count);
        }

        if (firstCheck.check) {
            return firstCheck.count;
        }

        if (secondCheck.check) {
            return secondCheck.count;
        }
        return -1;
    }

    static class Nope {
        int count;
        boolean check;

        public Nope(int count, boolean check) {
            this.count = count;
            this.check = check;
        }

        @Override
        public String toString() {
            return "Nope{" +
                    "count=" + count +
                    ", check=" + check +
                    '}';
        }
    }

    private static Nope checkFirst(int[] nums1, int[] nums2, int first, int last) {
        System.out.println(first + "<<>>" + last);
        int n = nums1.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums1[i] <= first && nums2[i] <= last) {
                continue;
            }
            int temp = nums1[i];
            nums1[i] = nums2[i];
            nums2[i] = temp;
            if (nums1[i] > first || nums2[i] > last) {
                return new Nope(count, false);
            }
            temp = nums2[i];
            nums2[i] = nums1[i];
            nums1[i] = temp;
            count++;
        }
        return new Nope(count, true);
    }

    public static int distributeCandies(int n, int limit) {
        int[] nums = new int[3];
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    nums[0] = i;
                    nums[1] = j;
                    nums[2] = k;
                    if (check(nums, limit, n))
                        count++;
                }
            }
        }
        return count;
    }

    private static boolean check(int[] nums, int limit, int n) {
        int first = nums[0];
        int sec = nums[1];
        int thr = nums[2];

        return (first <= limit && sec <= limit && thr <= limit) && (first + sec + thr == n);
    }

    private static List<List<String>> maker(String[][] nums) {
        List<List<String>> list = new ArrayList<>();
        int n = nums.length;
        for (String[] it : nums) {
            List<String> temp = new ArrayList<>();
            temp.addAll(Arrays.asList(it));
            list.add(temp);
        }
        return list;
    }

    public static List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = access_times.get(i).get(0);
            String time = access_times.get(i).get(1);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(time);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> nums = entry.getValue();
            Collections.sort(nums);
            int size = nums.size();
            if (size < 3) continue;
            for (int i = 0; i < size; i++) {
                int count = 0;
                int[] time = time(nums.get(i));
                int[] newTime = new int[2];
                if (time[0] == 23) {
                    newTime[0] = 23;
                    newTime[1] = 59;
                } else {
                    newTime[0] = time[0] + 1;
                    newTime[1] = time[1] - 1;
                }

                for (int j = i + 1; j < size; j++) {
                    int[] cur = time(nums.get(j));
                    if (cur[0] == time[0]) {
                        if (cur[0] <= newTime[0] && cur[1] >= time[1]) {
                            count++;
                        }
                    } else if (cur[0] == newTime[0]) {
                        if (cur[1] <= newTime[1]) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        break;
                    }
                }
                if (count >= 2) {
                    result.add(key);
                    break;
                }
            }
        }

        return result;
    }

    private static int[] time(String it) {
        int[] time = new int[2];

        time[0] = Integer.parseInt(it.substring(0, 2));
        time[1] = Integer.parseInt(it.substring(2));
        return time;
    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int ptn = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        int[] idx = new int[2];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() > 2) {
                while (ptn < n && map.size() > 2) {
                    char temp = s.charAt(ptn);
                    map.put(temp, map.get(temp) - 1);
                    if (map.get(temp) == 0) {
                        map.remove(temp);
                    }
                    ptn++;
                }
            }
            if (len < (i - ptn + 1)) {
                len = (i - ptn + 1);
                idx[0] = ptn;
                idx[1] = i;
            }
        }

        int count = 0;
        int first = 0;
        Map<Character, Integer> finalMap = new HashMap<>();
        for (int i = idx[0]; i <= idx[1]; i++) {
            char ch = s.charAt(i);
            finalMap.put(ch, finalMap.getOrDefault(ch, 0) + 1);
            int min = minType(finalMap);
            if (min > k && finalMap.size() >= 2) {
                while (first < idx[1] && minType(finalMap) > k) {
                    char asa = s.charAt(first);
                    finalMap.put(asa, finalMap.get(asa) - 1);
                    if (finalMap.get(asa) == 0) {
                        finalMap.remove(asa);
                    }
                    first++;
                }
            }
            count = Math.max(count, i - first + 1);
        }
        return count;
    }

    private static int minType(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        return min;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ptn = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (ptn < n && map.get(ch) > 1) {
                char temp = s.charAt(ptn);
                map.put(temp, map.get(temp) - 1);

                if (map.get(temp) == 0) {
                    map.remove(temp);
                }
                ptn++;
            }
            len = Math.max(len, i - ptn + 1);
        }
        return len;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        String correctString = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                correctString += String.valueOf(ch).toLowerCase();
            }
        }
        if (correctString.length() == 0) return true;
        StringBuilder sb = new StringBuilder(correctString);
        sb.reverse();
        return sb.toString().equals(correctString);
    }

    public int findChampion(int n, int[][] edges) {
        int[] degree = new int[n];
        int m = edges.length;
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            degree[v]++;
        }

        int count = 0;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                result = i;
                count++;
            }
        }

        return count > 1 ? -1 : result;
    }

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int count = 0;
        int row = -1;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    temp++;
                }
            }
            if (temp > count) {
                count = temp;
                row = i;
            }
        }
        return row;
    }


    static class Pair {
        char[] nums;

        public Pair(char[] nums) {
            this.nums = nums;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Arrays.equals(nums, pair.nums);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(nums);
        }
    }

    private static List<List<String>> solve(String[] nums) {
        Map<Pair, List<String>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            char[] arr = nums[i].toCharArray();
            Arrays.sort(arr);
            Pair pair = new Pair(arr);
            if (map.containsKey(pair)) {
                map.get(pair).add(nums[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(nums[i]);
                map.put(pair, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Pair, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        int lenLeft = left.length;
        int rightLen = right.length;
        Arrays.sort(left);
        Arrays.sort(right);

        if (lenLeft == 0) {
            return right[rightLen - 1] - right[0];
        }

        if (rightLen == 0) {
            return left[lenLeft - 1] - left[0];
        }

        return Math.max(right[rightLen - 1] - right[0], left[lenLeft - 1] - left[0]);
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int it : nums) {
            String str = String.valueOf(it);
            int len = str.length();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int num = Integer.parseInt(String.valueOf(str.charAt(i)));
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            if (map.size() > 2) {
                count++;
            }
        }
        return 0;
    }

    public static int minChanges(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 1; i = i + 2) {
            char cur = s.charAt(i);
            char next = s.charAt(i + 1);
            String str = "" + cur + next;
            if (str.equals("11") || str.equals("00")) {
                count += 2;
            }
        }

        return (n - count) / 2;
    }

    public static int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = i; k <= j; k++) {
                    map.put(nums.get(k), map.getOrDefault(nums.get(k), 0) + 1);
                }
                System.out.println(map);
                result += map.size() * map.size();
            }
        }
        return result;
    }


    public static long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        for (int i = 1; i < n - 1; i++) {
            int max = Math.max(nums[i - 1], Math.max(nums[i], nums[i + 1]));
            if (max < k) {
                int cal = k - max;
                nums[i - 1] += cal;
                nums[i] += cal;
                nums[i] += cal;
                result += cal;
            }
        }
        return result;
    }

    public static long minIncrementOperationsWrong(int[] nums, int k) {
        int n = nums.length;
        int subLen = 3;
        int count = 0;
        long result = 0;

        Queue<Tuple> pq = new PriorityQueue<>((a, b) -> b.changedValue == a.changedValue ? a.index - b.index : b.changedValue - a.changedValue);
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(i, nums[i], nums[i]));
            count++;

            //System.out.println(pq);
            if (count == subLen) {
                int num = nums[i - subLen + 1];
                int index = i - subLen + 1;
                if (pq.peek().changedValue < k) {
                    int cal = k - pq.peek().changedValue;
                    pq.peek().changedValue += cal;
                    result += cal;
                }
                int changedValue = pq.peek().changedValue;
                pq.remove(new Tuple(index, num, -1));
                if (pq.peek().value == num) {
                    pq.peek().changedValue = changedValue;
                }
                count--;
            }
        }
        return result;
    }

    static class Tuple {
        int index;
        int value;
        int changedValue;

        public Tuple(int index, int value, int changedValue) {
            this.index = index;
            this.value = value;
            this.changedValue = changedValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return index == tuple.index && value == tuple.value;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + value;
            result = 31 * result + changedValue;
            return result;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + index +
                    ", " + value +
                    ", " + changedValue +
                    '}';
        }

    }

    public static long minSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        long count1 = 0;
        int zero1 = 0;

        long count2 = 0;
        int zero2 = 0;

        for (int it : nums1) {
            if (it == 0) {
                zero1++;
            }
            count1 += it;
        }

        for (int it : nums2) {
            if (it == 0) {
                zero2++;
            }
            count2 += it;
        }

        System.out.println(count1 + "<<>>" + zero1);
        System.out.println(count2 + "<<>>" + zero2);

        if (zero1 == 0 && zero2 == 0) {
            if (count1 == count2) {
                return count1;
            }
            return -1;
        }

        if (zero2 == 0) {
            if (count2 < count1) return -1;
            if (count2 - count1 < zero1) return -1;
            return count2;
        }

        if (zero1 == 0) {
            if (count1 < count2) return -1;
            if (count1 - count2 < zero2) return -1;
            return count1;
        }

        if (count1 == count2) {
            return Math.max(zero1, zero2) + count1;
        }

//        if (count1 > count2) {
//            return count1 + zero1;
//        }
//        return count2 + zero2;
        return Math.max(count1 + zero1, count2 + zero2);
    }

}
