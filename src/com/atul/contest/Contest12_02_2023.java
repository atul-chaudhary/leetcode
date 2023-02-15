package com.atul.contest;

import java.util.*;

public class Contest12_02_2023 {
    public static void main(String[] args) {
        String str1 = "9133";
        String str2 = "0";
        System.out.println(multiply(str1, str2));
    }


    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        String result = "0";
        int space = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder temp1 = new StringBuilder();
            for (int k = 0; k < space; k++) {
                temp1.append(0);
            }
            for (int j = n2 - 1; j >= 0; j--) {
                int sum = 1;
                sum *= Integer.parseInt(String.valueOf(num1.charAt(i)));
                sum *= Integer.parseInt(String.valueOf(num2.charAt(j)));
                sum+=carry;
                if(sum > 9){
                    carry = sum/10;
                    int num = sum %10;
                    temp1.append(num);
                }else {
                    carry = 0;
                    temp1.append(sum);
                }
            }
            if(carry != 0) temp1.append(carry);
            result = addStrings(result, temp1.reverse().toString());
            space++;
        }
        //condition for checking all zero case
        boolean flag = true;
        for (int i = 0; i < result.length(); i++) {
            if(result.charAt(i) != '0'){
                flag = false;
            }
        }
        if(flag) return "0";
        return result;
    }

    public static String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int i = n1 - 1;
        int j = n2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += Integer.parseInt(String.valueOf(num1.charAt(i--)));
            if (j >= 0) sum += Integer.parseInt(String.valueOf(num2.charAt(j--)));

            if (sum > 9) {
                carry = 1;
                sum -= 10;
                sb.append(sum);
            } else {
                carry = 0;
                sb.append(sum);
            }
        }
        if (carry != 0) sb.append(1);
        return sb.reverse().toString();
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        String str = String.valueOf(k);
        int i = n - 1;
        int j = str.length() - 1;
        int carry = 0;
        List<Integer> result = new ArrayList<>();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += num[i--];
            if (j >= 0) sum += Integer.parseInt(String.valueOf(str.charAt(j--)));

            if (sum > 9) {
                carry = 1;
                sum -= 10;
                result.add(sum);
            } else {
                carry = 0;
                result.add(sum);
            }
        }
        if (carry != 0) result.add(1);
        Collections.reverse(result);
        return result;
    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit == 0) {
                map.putIfAbsent(digit, new int[]{i, i});
                continue;
            }
            int number = 0;
            for (int j = 0; j < i + 31 && j < n; j++) {
                int num = s.charAt(j) - '0';
                number *= 2;
                number += num;
                map.putIfAbsent(number, new int[]{i, j});
            }
        }

        int len = queries.length;
        int[][] result = new int[len][2];
        for (int i = 0; i < len; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int num = end ^ start;
            if (map.containsKey(num)) {
                result[i] = map.get(num);
            } else {
                result[i] = new int[]{-1, -1};
            }
        }
        return result;
    }


    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }

        String str = "";

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int fre = 0;
        for (int i = 0; i < n; i++) {
            fre++;
            map.put(arr[i][0], fre);
        }

        for (int i = 0; i < n; i++) {

        }

        return 0;
    }

    public static long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long result = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (left == right) {
                result += nums[left];
            } else {
                int first = nums[left];
                int last = nums[right];
                String str = first + "" + last;
                result += Integer.parseInt(str);
            }
            left++;
            right--;
        }
        return result;
    }


}
