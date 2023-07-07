package com.atul.contest;

import java.util.*;

public class Contest02_07_2023 {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'f' };
        System.out.println(findNext(chars, 'e'));
    }

    private static char findNext(char[] chars, char key) {
        int n = chars.length;
        int first = 0;
        int last = n - 1;
        int next = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (chars[mid] == key) {
                if (mid + 1 < n) return chars[mid + 1];
                return '@';
            } else if (chars[mid] < key) {
                first = mid + 1;
            } else {
                last = mid - 1;
                next = mid;
            }
        }
        System.out.println(next+"<<>>"+chars[next]);
        return '@';
    }

    static int findFloor(long arr[], int n, long x) {
        int first = 0;
        int last = n - 1;
        int floor = -1;
        int ceil = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                first = mid + 1;
                floor = mid;
            } else {
                last = mid - 1;
                ceil = mid;
            }
        }

        return 0;
        //return new Pair(floor, ceil);
    }


    static int search(int nums[], int l, int h, int key) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        int minIndex = findMinIndex(nums);
        System.out.println(minIndex);
        if (key >= nums[minIndex] && key <= nums[last]) {
            return binarySearch(nums, minIndex, last, key);
        }
        return binarySearch(nums, first, minIndex - 1, key);
    }

    private static int findMinIndex(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;
            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
                return mid;
            } else if (nums[mid] < nums[last]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return 0;
    }

    private static int binarySearch(int[] nums, int first, int last, int key) {
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        int first = 0;
        int last = n - 1;
        if (nums[first] < nums[last]) {
            return first;
        }
        int index = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            if (nums[prev] > nums[mid] && nums[mid] < nums[next]) {
                return mid;
            } else if (nums[mid] < nums[first]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return index;
    }

    static int count(int[] arr, int n, int x) {
        // code here
        boolean isPresent = false;
        int first = 0;
        int last = n - 1;
        int lastIndex = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == x) {
                isPresent = true;
                lastIndex = mid;
                first = mid + 1;
            } else if (arr[mid] < x) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        first = 0;
        last = (int) lastIndex;
        int firstIndex = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == x) {
                firstIndex = mid;
                last = mid - 1;
            } else if (arr[mid] < x) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return isPresent == false ? 0 : lastIndex - firstIndex + 1;
    }


    static ArrayList<Long> find(long arr[], int n, int x) {
        // code here
        int first = 0;
        int last = n - 1;
        long index = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == x) {
                index = mid;
                first = mid + 1;
            } else if (arr[mid] < x) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        first = 0;
        last = (int) index;
        long second = -1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == x) {
                second = mid;
                last = mid - 1;
            } else if (arr[mid] < x) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        ArrayList<Long> result = new ArrayList<>();
        result.add(second);
        result.add(index);
        return result;
    }

    static int searchInSorted(int arr[], int N, int K) {
        int n = arr.length;
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (K == arr[mid]) {
                return mid;
            } else if (K < arr[mid]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            if (sum >= target) {
                len = Math.min(len, j - i + 1);
                while (sum > target) {
                    sum -= nums[i];
                    len = Math.min(len, j - i + 1);
                    i++;
                }
                if (sum == target) {
                    len = Math.min(len, j - i + 1);
                }
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }


    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int ones = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zeros++;
            if (nums[i] == 1) ones++;

            if (nums[i] == 1) continue;
            int temp = i - 1;
            int first = 0;
            while (temp >= 0 && nums[temp] == 1) {
                first++;
                temp--;
            }
            int second = 0;
            temp = i + 1;
            while (temp < n && nums[temp] == 1) {
                second++;
                temp++;
            }
            ans = Math.max(ans, first + second);
        }
        if (zeros == 0) ans = ones - 1;
        return ans;
    }

    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) continue;
            return entry.getKey();
        }
        return -1;
    }

    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        int result = 0;
        while (j < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > 1 && map.lastKey() - map.firstKey() > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        if (n == 1) {
            if (nums[0] % 2 == 0 && nums[0] <= threshold) {
                return 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                ans = Math.max(ans, 1);
                for (int j = i; j < n; j++) {
                    if (j < n - 1) {
                        if (nums[j] % 2 != nums[j + 1] % 2) {
                            ans = Math.max(ans, j - i + 1);
                        }
                    } else {
                        if (nums[j] <= threshold) {
                            ans = Math.max(ans, j - i + 1);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int first = i;
            int second = n - first;

            if ((vis[first] && vis[second]) || (isPrime(first, vis) && isPrime(second, vis))) {
                if (second < first) {
                    return result;
                }
                if (first + second == n) {
                    List<Integer> nums = new ArrayList<>();
                    nums.add(first);
                    nums.add(second);
                    result.add(nums);
                }
            }
        }
        return result;
    }

    private static boolean isPrime(int n, boolean[] vis) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        vis[n] = true;
        return true;
    }
}
