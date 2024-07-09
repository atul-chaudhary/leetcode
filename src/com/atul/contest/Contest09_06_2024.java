package com.atul.contest;

import java.util.*;

public class Contest09_06_2024 {
    public static void main(String[] args) {
        System.out.println(validStrings(3));
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return 0;
    }




    public static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        solve("", 0, n, result);
        return result;
    }

    private static void solve(String str, int index, int n, List<String> result) {
        if (index == n) {
            if (valid(str)) {
                result.add(str);
                return;
            }
            return;
        }
        solve(str + '0', index + 1, n, result);
        solve(str + '1', index + 1, n, result);
    }

    private static boolean valid(String str) {
        return !str.contains("00");
    }

    public static int passThePillow(int n, int time) {
        int num = n - 1;
        if (time < num) {
            return time + 1;
        }
        int div = time / num;
        int rem = time % num;

        if (div % 2 == 0 && rem != 0) {
            return rem;
        } else if (div % 2 == 0 && rem != 0) {
            return 1;
        } else if (div % 2 != 0 && rem != 0) {
            return n - rem;
        } else {
            return n;
        }
    }

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next == null) {
            return new int[]{-1, -1};
        }
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head.next;
        ListNode prev = head;
        int index = 1;
        int minResult = Integer.MAX_VALUE;
        while (temp.next != null) {
            if (temp.val < prev.val && temp.val < temp.next.val) {
                int num;
                if (arr.size() >= 1) {
                    num = arr.get(arr.size() - 1);
                    minResult = Math.min(minResult, index - num);
                }
                arr.add(index);
            }

            if (temp.val > prev.val && temp.val > temp.next.val) {
                int num;
                if (arr.size() >= 1) {
                    num = arr.get(arr.size() - 1);
                    minResult = Math.min(minResult, index - num);
                }
                arr.add(index);
            }
            prev = temp;
            temp = temp.next;
            index++;
        }
        if (arr.size() == 0 || arr.size() == 1) {
            return new int[]{-1, -1};
        }
        return new int[]{minResult, arr.get(arr.size() - 1) - arr.get(0)};
    }

    public static int maximumLength(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            arr.add((nums[i] + nums[i - 1]) % 2);
        }
        int cOne = 0;
        int cZero = 0;
        for (int it : arr) {
            if (it == 0) cZero++;
            if (it == 1) cOne++;
        }

        return Math.max(cOne, cZero) + 1;
    }

    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int it : nums) {
            count += Math.min(it % 3, 3 - (it % 3));
        }
        return count;
    }

    public static int minOperations2(int[] nums) {
        int n = nums.length;
        int count = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int curNum = 0;
            if (cur % 2 == 0) {
                curNum = nums[i];
            } else {
                curNum = nums[i] == 0 ? 1 : 0;
            }

            if (curNum == 0) {
                cur++;
                count++;
            }
        }
        return count;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 3 + 1; i++) {
            if (nums[i] == 0) {
                count++;
                for (int j = i; j < i + 3; j++) {
                    nums[j] = nums[j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                return -1;
            }
        }
        return count;
    }

    public static int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;

        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    x1 = Math.min(j, x1);
                    x2 = Math.max(j, x2);

                    y1 = Math.min(i, y1);
                    y2 = Math.max(i, y2);
                }
            }
        }

        if (count == 1) {
            return 1;
        }
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    public static long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        long result = 0;
        for (int it : hours) {
            int rem = it % 24;
            int opp = (24 - rem) % 24;
            if (map.containsKey(opp)) {
                result += map.get(opp);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return result;
    }


    public static int numberOfChild(int n, int k) {
        int div = k / n - 1;
        int remainder = k % n - 1;
        if (div >= 1 && remainder == 0) {
            return n - 1;
        }
        if (div % 2 == 0) {
            return remainder;
        } else {
            return n - remainder - 1;
        }
    }


    public static String clearDigits(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        TreeMap<Integer, Character> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                map.put(i, ch);
            }
        }

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int floor = map.floorKey(i);
                chars[i] = '?';
                chars[floor] = '?';
                map.remove(floor);
            }
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch != '?') {
                result += ch;
            }
        }
        return result;
    }

    static class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    +num +
                    "," + freq +
                    '}';
        }
    }

    static class Tuple {
        int num;
        int index;
        int win;

        public Tuple(int num, int index, int win) {
            this.num = num;
            this.index = index;
            this.win = win;
        }

    }

    public static int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        ArrayDeque<Tuple> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arrayDeque.add(new Tuple(skills[i], i, 0));
        }

        if (k > n) {
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < n; i++) {
                int num = skills[i];
                if (num > max) {
                    max = num;
                    index = i;
                }
            }
            return index;
        }
        while (true) {
            Tuple first = arrayDeque.pollFirst();
            Tuple sec = arrayDeque.pollFirst();

            if (first.win == k) {
                return first.index;
            }

            if (sec.win == k) {
                return sec.index;
            }

            if (first.num > sec.num) {
                first.win++;
                arrayDeque.addFirst(first);
                arrayDeque.addLast(sec);
            } else {
                sec.win++;
                arrayDeque.addFirst(sec);
                arrayDeque.addLast(first);
            }
        }
    }


    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : hand) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.num - b.num);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            pq.offer(new Pair(key, val));
        }

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            Queue<Pair> arr = new LinkedList<>();
            if (temp.freq > 1) {
                temp.freq--;
                arr.add(temp);
            }
            Pair prev = null;
            if (pq.size() < groupSize - 1) return false;
            for (int i = 0; i < groupSize - 1; i++) {
                Pair p = pq.poll();
                if (prev == null) {
                    if (temp.num + 1 != p.num) {
                        return false;
                    }
                } else {
                    if (prev.num + 1 != p.num) {
                        return false;
                    }
                }
                if (p.freq > 1) {
                    p.freq--;
                    arr.add(p);
                }
                prev = p;
            }

            for (int i = 0; i < arr.size(); i++) {
                pq.offer(arr.poll());
            }
            System.out.println(pq);
        }

        return true;
    }
}
