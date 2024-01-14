package com.atul.contest;

import java.util.*;

class Yo {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        return solve(nums, 0, Integer.MIN_VALUE, new HashMap<>());
    }

    private static int solve(int[] nums, int index, int prevIndex, Map<String, Integer> map) {
        if (index >= nums.length) {
            return 0;
        }

        String key = index + "|" + prevIndex;
        if (map.containsKey(key)) return map.get(key);

        int take = 0;
        if (prevIndex == Integer.MIN_VALUE || nums[index] > nums[prevIndex]) {
            take = 1 + solve(nums, index + 1, index, map);
        }
        int notTake = solve(nums, index + 1, prevIndex, map);

        int result = Math.max(take, notTake);
        map.put(key, result);
        return result;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == 1) return -1;
            if (val % 3 == 0) {
                count += val / 3;
            } else if (val % 3 == 1) {
                int prev = ((val / 3) - 1);
                count += prev + (val - (3 * prev)) / 2;
            } else {
                count += val / 3 + 1;
            }
        }
        return count;
    }

    private static int solve(Node node, int first, int second) {
        if (node == null) {
            return -1;
        }
        if (node.val == first || node.val == second) {
            return Integer.MAX_VALUE;
        }

        int left = solve(node.left, first, second);
        int right = solve(node.right, first, second);

        if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
            return node.val;
        }
        return Math.max(left, right);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

public class Contest03_12_2023 {


    public static int maximumLength(String s) {
        int n = s.length();
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subString = s.substring(i, j + 1);
                if (single(subString) && count(subString, s)) {
                    System.out.println(subString);
                    max = Math.max(max, subString.length());
                }
            }
        }
        return max;
    }

    private static boolean single(String sub) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            set.add(ch);
        }
        return set.size() == 1;
    }

    private static boolean count(String subString, String str) {
        int n = str.length();
        int m = subString.length();
        int count = 0;
        for (int i = 0; i < n - m + 1; i++) {
            char ch = str.charAt(i);
            char subChar = subString.charAt(0);
            if (ch == subChar) {
                boolean flag = true;
                int index = 0;
                for (int j = i; j < i + m; j++) {
                    if (str.charAt(j) != subString.charAt(index++)) {
                        flag = false;
                    }
                }
                if (flag) {
                    count++;
                }
            }
        }
        return count >= 3;
    }

    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int it : nums) {
            if (it % 2 == 0) {
                count++;
            }
        }
        return count >= 2;
    }

    public static int maxLengthBetweenEqualCharacterOpt(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, i);
            if (map.containsKey(ch)) {
                max = Math.max(max, i - map.get(ch) - 1);
            }
        }

        return max;
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        int max = -1;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            Character key = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() < 2) {
                continue;
            }
            max = Math.max(max, value.get(value.size() - 1) - value.get(0) - 1);
        }
        return max;
    }


    public static long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] temp = new long[n];
        temp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            temp[i] = nums[i] + temp[i - 1];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(temp));
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < temp[i - 1]) {
                return temp[i];
            }
        }
        return -1;
    }

    public static int[] numberGame(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.offer(it);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = pq.poll();
            nums[index] = second;
            nums[index + 1] = first;
            index += 2;
        }
        return nums;
    }

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] hf = new int[hFences.length + 2];
        hf[0] = 1;
        hf[hf.length - 1] = m;
        for (int i = 1; i <= hFences.length; i++) {
            hf[i] = hFences[i - 1];
        }

        int[] rf = new int[vFences.length + 2];
        rf[0] = 1;
        rf[rf.length - 1] = n;
        for (int i = 1; i <= vFences.length; i++) {
            rf[i] = vFences[i - 1];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < hf.length; i++) {
            for (int j = 0; j < hf.length; j++) {
                if (i != j) {
                    set.add(Math.abs(hf[i] - hf[j]));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < rf.length; i++) {
            for (int j = 0; j < rf.length; j++) {
                int abs = Math.abs(rf[i] - rf[j]);
                if (i != j && set.contains(abs)) {
                    ans = Math.max(ans, abs);
                }
            }
        }
        int mod = (int) 1e9 + 7;
        return ans == 0 ? -1 : (ans * ans) % mod;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (x != pair.x) return false;
            return y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static boolean isPathCrossingOpt(String path) {
        Set<Pair> set = new HashSet<>();
        Pair last = new Pair(0, 0);
        set.add(last);
        int n = path.length();
        for (int i = 0; i < n; i++) {
            char ch = path.charAt(i);
            Pair temp = null;
            if (ch == 'N') {
                temp = new Pair(last.x, last.y + 1);
            } else if (ch == 'E') {
                temp = new Pair(last.x + 1, last.y);
            } else if (ch == 'S') {
                temp = new Pair(last.x, last.y - 1);
            } else {
                temp = new Pair(last.x - 1, last.y);
            }
            if (set.contains(temp)) return true;
            last = temp;
        }
        return false;
    }

    public static boolean isPathCrossing(String path) {
        int n = path.length();
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(0, 0));
        for (int i = 0; i < n; i++) {
            char ch = path.charAt(i);
            Pair temp = list.get(list.size() - 1);
            if (ch == 'N') {
                list.add(new Pair(temp.x, temp.y + 1));
            } else if (ch == 'E') {
                list.add(new Pair(temp.x + 1, temp.y));
            } else if (ch == 'S') {
                list.add(new Pair(temp.x, temp.y - 1));
            } else {
                list.add(new Pair(temp.x - 1, temp.y));
            }
        }
        System.out.println(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                int cal = (int) Math.pow(solveSquare(list.get(i).x, list.get(j).x) + solveSquare(list.get(i).y, list.get(j).y), 0.5);
                System.out.println(cal + "<<>> " + list.get(i) + "<<>>" + list.get(j));
                if (cal == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int solveSquare(int a, int b) {
        return (int) Math.pow(Math.abs(a - b), 2);
    }

    private static boolean all9(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch != '9') {
                return false;
            }
        }
        return true;
    }

    public static long minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n % 2 == 0) {
            int first = (n / 2) - 1;
            int second = (n / 2);
            int firstprev = closedNumberPrev(nums[first]);
            int firstNext = closedNumberNext(nums[first]);

            long firstNum = Math.min(calculate(nums, firstprev), calculate(nums, firstNext));

            int secondPrev = closedNumberPrev(nums[second]);
            int secondNext = Math.abs(closedNumberNext(nums[second]));

            long secondNum = Math.min(calculate(nums, secondPrev), calculate(nums, secondNext));
            return Math.min(firstNum, secondNum);
        } else {
            int second = n / 2;
            int secondPrev = closedNumberPrev(nums[second]);
            int secondNext = closedNumberNext(nums[second]);
            return Math.min(calculate(nums, secondPrev), calculate(nums, secondNext));
        }
    }

    private static int calculate(int[] nums, long calNumber) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += Math.abs(nums[i] - calNumber);
        }
        return result;
    }

    private static int closedNumberPrev(int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        int n = str.length();
        //even case
        if (n % 2 == 0) {
            int first = (n / 2) - 1;
            int second = (n / 2);
            while (first >= 0 && second < n) {
                int num1 = Integer.parseInt(String.valueOf(str.charAt(first)));
                int num2 = Integer.parseInt(String.valueOf(str.charAt(second)));
                int min = Math.min(num1, num2);
                str.replace(first, first + 1, String.valueOf(min));
                str.replace(second, second + 1, String.valueOf(min));
                first--;
                second++;
            }
        } else {
            int first = (n / 2) - 1;
            int second = (n / 2) + 1;
            while (first >= 0 && second < n) {
                int num1 = Integer.parseInt(String.valueOf(str.charAt(first)));
                int num2 = Integer.parseInt(String.valueOf(str.charAt(second)));
                int min = Math.min(num1, num2);
                str.replace(first, first + 1, String.valueOf(min));
                str.replace(second, second + 1, String.valueOf(min));
                first--;
                second++;
            }
        }
        return Integer.parseInt(str.toString());
    }

    private static int closedNumberNext(int num) {
        StringBuilder str = new StringBuilder(String.valueOf(num));
        int n = str.length();
        //even case
        if (n % 2 == 0) {
            int first = (n / 2) - 1;
            int second = (n / 2);
            while (first >= 0 && second < n) {
                int num1 = Integer.parseInt(String.valueOf(str.charAt(first)));
                int num2 = Integer.parseInt(String.valueOf(str.charAt(second)));
                int min = Math.max(num1, num2);
                str.replace(first, first + 1, String.valueOf(min));
                str.replace(second, second + 1, String.valueOf(min));
                first--;
                second++;
            }
        } else {
            int first = (n / 2) - 1;
            int second = (n / 2) + 1;
            while (first >= 0 && second < n) {
                int num1 = Integer.parseInt(String.valueOf(str.charAt(first)));
                int num2 = Integer.parseInt(String.valueOf(str.charAt(second)));
                int min = Math.max(num1, num2);
                str.replace(first, first + 1, String.valueOf(min));
                str.replace(second, second + 1, String.valueOf(min));
                first--;
                second++;
            }
        }
        return Integer.parseInt(str.toString());
    }

    private static int number(int num, boolean isPrev) {
        //even case
        return 0;
    }

    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int num = n / 3;
        int[][] result = new int[num][3];
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < n; i = i + 3) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (Math.abs(first - second) > k || Math.abs(second - third) > k || Math.abs(first - third) > k) {
                flag = true;
            }
            result[index++] = new int[]{first, second, third};
        }
        if (flag) return new int[0][0];
        return result;
    }


    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        int max = Integer.MIN_VALUE;
        for (int it : nums) {
            max = Math.max(max, it);
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n) {
            if (nums[i] == max) {
                count++;
            }

            if (count == k) {
                result += n - i;
                while (j < i && count >= k) {
                    result += n - i;

                    if (nums[j] == max) {
                        count--;
                    }
                    j++;
                }
            }
            i++;
        }
        return result;
    }

    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int ai = variables[i][0];
            int bi = variables[i][1];
            int ci = variables[i][2];
            int mi = variables[i][3];

            int first = 1;
            for (int j = 1; j <= bi; j++) {
                first = (first * ai) % 10;
            }

            int second = 1;
            for (int j = 1; j <= ci; j++) {
                second = (second * first) % mi;
            }
            if (second == target) {
                result.add(i);
            }
        }
        return result;
    }


    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return count;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }


    private static Node rev(Node head) {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    private static void trav(Node list) {
        Node temp = list;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int currentMax = 0;
        int additions = 0;
        int index = 0;
        for (int i = 1; i <= target; i++) {
            if (index < coins.length && coins[index] <= i) {
                currentMax += coins[index];
                index++;
            } else {
                if (currentMax >= i) {
                    continue;
                }
                additions++;
                currentMax += i;
            }
        }

        return additions;
    }
}
