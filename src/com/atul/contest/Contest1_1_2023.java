package com.atul.contest;

import java.util.HashMap;
import java.util.HashSet;

public class Contest1_1_2023 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        int n = words.length;
        int m = pattern.length();
        if (n != m) return false;
        for (int i = 0; i < n; i++) {
            if (map1.containsKey(pattern.charAt(i))) {
                if (!map1.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }

            } else if (map2.containsKey(words[i])) {
                if (map2.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                map1.put(pattern.charAt(i), words[i]);
                map2.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static int minimumPartition(String s, int k) {
        int n = s.length();
        String str = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            str += s.charAt(i);
            if (Long.parseLong(str) > k) {
                str = "";
                str += s.charAt(i);
                if (Long.parseLong(str) > k) {
                    return -1;
                }
                count++;
            }
        }
        return count;
    }

    public static int minimumPartitionopt(String s, int k) {
        int i = 0, c = 0, j = 0;
        // i - left pointer
        // j - right pointer
        while (j < s.length()) {
            while (j < s.length() && Long.parseLong(s.substring(i, j + 1)) <= k)
                j++;
            c++;
            if (i == j)
                return -1;
            i = j;
        }
        return c;
    }

    public static int[] closestPrimes(int left, int right) {
        Integer last = null;
        int count = 0;
        int distance = Integer.MAX_VALUE;
        int cur1 = -1;
        int cur2 = -1;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                count++;
                if (last != null && i - last < distance) {
                    cur1 = last;
                    cur2 = i;
                    distance = i - last;
                }
                last = i;
            }
        }

        if (count < 2) return new int[]{-1, -1};
        return new int[]{cur1, cur2};
    }

    public static boolean isPrime(int n) {
        // 0 and 1 are neither prime nor composite numbers
        if (n == 0 || n == 1) {
            return false;
        }
        // 2 is a prime number
        if (n == 2) {
            return true;
        }
        // every composite number has a prime factor
        // less than or equal to its square root.
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static int distinctPrimeFactors(int[] nums) {
        HashSet<Long> set = new HashSet<>();
        for (int it : nums) {
            primeFactors(it, set);
        }
        System.out.println(set);
        return set.size();
    }


    public static void primeFactors(long n, HashSet<Long> number) {
        while (n % 2 == 0) {
            number.add(2L);
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                number.add(i);
                n /= i;
            }
        }

        if (n > 2)
            number.add(n);

    }

    public static int countDigits(int num) {
        String number = String.valueOf(num);
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            if (num % n == 0) {
                count++;
            }
        }
        return count;
    }
}
