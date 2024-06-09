package com.atul.contest;

import java.util.*;

public class Contest10_03_2024 {
    public static void main(String[] args) {
        int[][] meetings = {{3, 49}, {23, 44}, {21, 56}, {26, 55}, {23, 52}, {2, 9}, {1, 48}, {3, 31}};
        int days = 57;
        System.out.println(countDays(days, meetings));
    }



    public static int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        int count = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(meetings));
        int last = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > last) {
                count += meetings[i][0] - last - 1;
            }
            last = Math.max(last, meetings[i][1]);
        }
        if (meetings[0][0] > 1) {
            count += meetings[0][0] - 1;
        }

        if (last < days) {
            count += days - last;
        }
        return count;
    }

    static class Pair {
        int va;
        char ch;

        public Pair(int va, char ch) {
            this.va = va;
            this.ch = ch;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    +va +
                    "," + ch +
                    '}';
        }
    }

    public static String compressedString(String word) {
        int n = word.length();
        List<Pair> arr = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < n; i++) {
            char ch = word.charAt(i);
            char prev = word.charAt(i - 1);
            if (ch != prev) {
                arr.add(new Pair(count, prev));
                count = 0;
            }

            count++;
            if (count == 9) {
                arr.add(new Pair(count, ch));
                count = 0;
            }
        }
        arr.add(new Pair(count, word.charAt(word.length() - 1)));
        System.out.println(arr);

        String result = "";
        for (int i = 0; i < arr.size(); i++) {
            Pair p = arr.get(i);
            result += p.va + "" + p.ch;
        }
        return result;
    }

    public static int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> ballsMap = new HashMap<>();
        Map<Integer, Set<Integer>> colorsMap = new HashMap<>();
        int[] result = new int[n];
        int index = 0;
        for (int[] it : queries) {
            int ball = it[0];
            int col = it[1];

            if (ballsMap.containsKey(ball) && ballsMap.get(ball) != col) {
                colorsMap.get(ballsMap.get(ball)).remove(ball);
                if (colorsMap.get(ballsMap.get(ball)).isEmpty()) {
                    colorsMap.remove(ballsMap.get(ball));
                }
            }
            System.out.println(ballsMap);
            System.out.println(colorsMap);

            ballsMap.put(ball, col);
            colorsMap.putIfAbsent(col, new HashSet<>());
            colorsMap.get(col).add(ball);

            System.out.println(ballsMap);
            System.out.println(colorsMap);
            System.out.println();
            result[index++] = colorsMap.size();
        }
        return result;
    }

    static class Yo {
        int first;
        int sec;

        public Yo(int first, int sec) {
            this.first = first;
            this.sec = sec;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Yo yo = (Yo) o;

            if (first != yo.first) return false;
            return sec == yo.sec;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, sec);
        }
    }


    public int duplicateNumbersXOR(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val >= 2) {
                result = result ^ key;
            }
        }
        return result;
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n = nums.length;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                arrayList.add(i);
            }
        }

        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int it = queries[i];
            if (arrayList.size() < it) {
                result[i] = -1;
            } else {
                result[i] = arrayList.get(it - 1);
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minTillNow = prices[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minTillNow = Math.min(minTillNow, prices[i]);
            ans = Math.max(ans, prices[i] - minTillNow);
        }
        return ans;
    }

    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (solve(nums[i]) == solve(nums[i + 1])) {
                return false;
            }
        }
        return true;
    }


    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] result = new boolean[m];

        int[] count = new int[n - 1];
        int fal = 0;
        for (int i = 0; i < n - 1; i++) {
            if (solve(nums[i]) == solve(nums[i + 1])) {
                fal++;
            }
            count[i] = fal;
        }
        System.out.println(Arrays.toString(count));
        //System.out.println(index);
        for (int i = 0; i < m; i++) {
            int first = queries[i][0];
            int sec = queries[i][1] - 1;

        }
        return result;
    }

    private static boolean solve(int num) {
        return num % 2 == 0;
    }


    public static int numberOfSpecialChars(String word) {
        int n = word.length();
        Set<Character> lowerCase = new HashSet<>();
        Set<Character> upperCase = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerCase.add(ch);
            }
            if (ch >= 'A' && ch <= 'Z') {
                upperCase.add(ch);
            }
        }

        int count = 0;
        for (Character ch : lowerCase) {
            char temp = String.valueOf(ch).toUpperCase().charAt(0);
            if (upperCase.contains(temp)) {
                count++;
            }
        }
        return count;
    }

    public static int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            if (isPrime(nums[first]) && isPrime(nums[last])) {
                return last - first;
            }
            if (!isPrime(nums[first])) {
                first++;
            }

            if (!isPrime(nums[last])) {
                last--;
            }
        }
        return 0;
    }

    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }


    public static String findLatestTime(String s) {
        String[] str = s.split(":");
        if (str[0].equals("??") && str[1].equals("??")) {
            return "11:59";
        } else if (str[0].equals("??")) {
            if (str[1].contains("?")) {
                for (int i = 9; i >= 0; i--) {
                    String second = str[1].replaceAll("\\?", "" + i);
                    if (isValid2("11" + ":" + second)) {
                        return "11" + ":" + second;
                    }
                }
            }
            return "11" + ":" + str[1];
        } else if (str[1].equals("??")) {
            if (str[0].contains("?")) {
                for (int i = 9; i >= 0; i--) {
                    String first = str[0].replaceAll("\\?", "" + i);
                    if (isValid2(first + ":" + "59")) {
                        return first + ":" + "59";
                    }
                }
            }
            return str[0] + ":" + "59";
        } else {
            for (int i = 9; i >= 0; i--) {
                String first = str[0].replaceAll("\\?", "" + i);
                for (int j = 9; j >= 0; j--) {
                    String second = str[1].replaceAll("\\?", "" + j);
                    if (isValid2(first + ":" + second)) {
                        return first + ":" + second;
                    }
                }
            }
        }
        return "";
    }

    private static boolean isValid2(String s) {
        String[] str = s.split(":");
        int first = Integer.parseInt(str[0]);
        int second = Integer.parseInt(str[1]);
        if (first >= 0 && first <= 11 && second >= 0 && second <= 59) {
            return true;
        }
        return false;
    }


    private static void solve(String s1, String s2) {
        if (s1.equals(s2)) {
            //do sometthing
        } else {
            //do something
        }
    }

    public static String getSmallestString(String s1, int k) {
        String formed = "";
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            formed += "z";
        }
        s = formed;
        solve(s1, formed, 0, k);
        return s;
    }

    static String s = "";

    private static void solve(String s1, String s2, int index, int k) {
        if (index > s1.length()) {
            return;
        }
        if (s1.length() == index) {
            if (distance(s1, s2, k)) {
                System.out.println(s2 + "<<>>");
                if (s2.compareTo(s) < 0) {
                    s = s2;
                } else {
                    return;
                }
            }
            return;
        }

        for (int i = 0; i < 25; i++) {
            StringBuilder sb = new StringBuilder(s2);
            sb.replace(index, index + 1, String.valueOf((char) (i + 97)));
            solve(s1, sb.toString(), index + 1, k);
        }
    }

    private static boolean distance(String s1, String s2, int k) {
        int count = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            count += cyclicDistance(s1.charAt(i), s2.charAt(i));
        }
        return count <= k;
    }

    public static int cyclicDistance(char char1, char char2) {
        int index1 = char1 - 'a'; // Convert character to alphabet index (0-25)
        int index2 = char2 - 'a'; // Convert character to alphabet index (0-25)
        int clockwiseDistance = (index2 - index1 + 26) % 26;
        int counterclockwiseDistance = (index1 - index2 + 26) % 26;
        return Math.min(clockwiseDistance, counterclockwiseDistance);
    }

    public static long countAlternatingSubarrays(int[] nums) {
        long result = 1;
        int lvl = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                lvl++;
            } else {
                lvl = 1;
            }
            result += lvl;
        }
        return result;
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBot = 0;
        int botDrunk = 0;
        int fullBot = numBottles;

        while (fullBot != 0) {
            emptyBot += fullBot;
            botDrunk += fullBot;
            fullBot -= fullBot;
            while (numExchange <= emptyBot) {
                emptyBot -= numExchange;
                numExchange++;
                fullBot++;
            }

        }
        return botDrunk;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }


    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                result.add(nums[i]);
            }
            set.add(nums[i]);
        }
        return result;
    }


    public static int maximumLengthSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String str = s.substring(i, j + 1);
                if (allCharPresent(map, str)) {
                    max = Math.max(max, str.length());
                }
            }
        }

        return max;
    }

    private static boolean allCharPresent(Map<Character, Integer> in, String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : in.entrySet()) {
            char key = entry.getKey();
            if (map.containsKey(key) && map.get(key) > 2) {
                return false;
            }
        }
        return true;
    }

    public static int minimumDeletions1(String word, int k) {
        return 0;
    }

    public static int minimumDeletions(String word, int k) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Integer> arr = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int val = entry.getValue();
            arr.add(val);
        }
        Collections.sort(arr);
        System.out.println(arr);
        int m = arr.size();
        if (m == 1) return 0;
        int index = m - 1;
        int result = 0;
        for (int i = 0; i < m - 1; i++) {
            int last = arr.get(index);
            int cur = Math.abs(last - arr.get(i));
            if (cur <= k) {
                break;
            }

        }

        int res = 0;
        int idx = 0;
        for (int i = m - 1; i >= 1; i--) {
            int last = arr.get(i);
            int cur = Math.abs(last - arr.get(idx));
            if (cur <= k) {
                break;
            }
            int fin = Math.abs(cur - k);
            res += fin;
        }
        return result;
    }


    public static long countSubstrings(String s, char c) {
        int count = 0;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
                result += count;
            }
        }
        return result;
    }

    public static int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for (int it : apple) {
            sum += it;
        }
        int ans = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (sum <= 0) {
                break;
            }
            sum -= capacity[i];
            ans++;
        }
        return ans;
    }

    public static long maximumHappinessSum(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int cur = 0;
        long ans = 0;
        for (int i = n - 1; i >= n - k; i--) {
            if (nums[i] >= cur) {
                ans += (nums[i] - cur);
            }
            cur++;
        }
        return ans;
    }
}
