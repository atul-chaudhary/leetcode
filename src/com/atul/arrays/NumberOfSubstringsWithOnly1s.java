package com.atul.arrays;

public class NumberOfSubstringsWithOnly1s {
    public static void main(String[] args) {
        String str = "111111";
        System.out.println(numSub(str));
    }

    public static int numSub(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        long sum = 0;
        long curr = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                curr++;
                continue;
            } else {
                long total = curr * (curr +1);
                sum = (sum + (total / 2)) % mod;
                curr = 0;
            }
        }
        if(curr != 0){
            long total = curr * (curr +1);
            sum = (sum + (total / 2)) % mod;
        }
        return (int)sum;
    }
}


