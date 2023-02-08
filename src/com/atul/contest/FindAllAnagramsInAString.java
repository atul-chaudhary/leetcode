package com.atul.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagramsOpt(s, p));
    }

    /*
    int helper(int idx,vector<int> &v,int n,int k,vector<int> &dp){
        if(idx==n)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int result=helper(idx+1,v,n,k,dp);
        int start=v[idx];
        int end=start+k;
        int mx=upper_bound(v.begin()+idx,v.end(),end)-v.begin();
        int op= max(result,mx-idx);

        return dp[idx]=op;
    }
    int maximizeWin(vector<int>& v, int k) {

        int n=v.size();
        int ans=0;
        vector<int> dp(n,-1);
        for(int i=0;i<n;i++){
            int start=v[i];
            int end=start+k;
            int k1=upper_bound(v.begin()+i,v.end(),end)-v.begin();
            int op=k1-i+helper(k1,v,n,k,dp);
            // cout<<k-i<<" "<<op<<endl;
            ans=max(op,ans);
        }
        return ans;
    }
*/
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int left = 1;
        int right = (int) 1e9;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(helper(nums, k, mid)){
                ans = Math.min(ans, mid);
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

    private static boolean helper(int[] nums, int k, int cur){
        int i = 0;
        int n = nums.length;
        while (i < n){
            if(nums[i] <= cur){
                k--;
                i+=2;
            }else {
                i++;
            }

            if(k==0){
                return true;
            }
        }
        return k==0;
    }

    public static List<Integer> findAnagramsOpt(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        char[] pChar = new char[26];
        for (int i = 0; i < plen; i++) {
            pChar[p.charAt(i) - 'a']++;
        }
        int count = 0;
        List<Integer> result = new ArrayList<>();
        char[] sChar = new char[26];
        for (int i = 0; i < slen; i++) {
            count++;
            sChar[s.charAt(i) - 'a']++;

            if (count == plen) {
                count--;
                int index = i - plen + 1;
                if (check(sChar, pChar)) {
                    result.add(index);
                }
                sChar[s.charAt(index) - 'a']--;
            }
        }
        return result;
    }

    private static boolean check(char[] chars, char[] charsp) {
        for (int i = 0; i < 26; i++) {
            if (chars[i] != charsp[i]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        char[] ptr = p.toCharArray();
        Arrays.sort(ptr);
        int sn = s.length();
        int count = 0;
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sn; i++) {
            count++;
            sb.append(s.charAt(i));
            if (count == n) {
                int index = i - n + 1;
                if (chec(sb.toString(), new String(ptr))) {
                    result.add(index);
                }
                sb.deleteCharAt(0);
                count--;
            }
        }
        return result;
    }

    private static boolean chec(String a, String ptr) {
        char[] atr = a.toCharArray();
        Arrays.sort(atr);
        if (new String(atr).equals(ptr)) {
            return true;
        }
        return false;
    }
}
