package com.atul.contest;

import java.util.*;

public class Contest25_12_2022 {
    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        //System.out.println(takeCharacters(s, k));
    }


    public int takeCharactersOpt(String s, int k) {
        int n = s.length();
        int totalCountA = 0;
        int totalCountB = 0;
        int totalCountC = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='a') totalCountA++;
            if(s.charAt(i)=='b') totalCountB++;
            if(s.charAt(i) == 'c')totalCountC++;
        }

        int remCountA = totalCountA - k;
        int remCountB = totalCountB - k;
        int remCountC = totalCountC - k;
        int j = 0;
        int curA = 0;
        int curB = 0;
        int curC = 0;
        int curLen = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') curA++;
            if(s.charAt(i) == 'b') curB++;
            if(s.charAt(i) == 'c') curC++;

            while (j < i && (curA >= remCountA && curB < remCountB && curC < remCountC)){

            }
        }


        return 0;
    }



    /*
    class Solution {
public:
    int takeCharacters(string s, int k) {
        int ans, n=s.size(), i, j, c, ca, cb, cc;
        ans=-1;

        unordered_map<int, int> mp_a, mp_b, mp_c;
        mp_a[0]=mp_b[0]=mp_c[0]=n;
        c=0;

        for(i=n-1; i>=0; i--){
            if(s[i]=='a'){
                c++;
                mp_a[c]=i;
            }
        }

        c=0;

        for(i=n-1; i>=0; i--){
            if(s[i]=='b'){
                c++;
                mp_b[c]=i;
            }
        }

        c=0;

        for(i=n-1; i>=0; i--){
            if(s[i]=='c'){
                c++;
                mp_c[c]=i;
            }
        }

        if(k==0){
            return 0;
        }
        if(mp_a.find(k)==mp_a.end() || mp_b.find(k)==mp_b.end() || mp_c.find(k)==mp_c.end()){
            return -1;
        }

        ca=cb=cc=0;
        ans=n-min(mp_a[max(0, k-ca)], min(mp_b[max(0, k-cb)], mp_c[max(0, k-cc)]));
        for(i=0; i<n-1; i++)
        {
            if(s[i]=='a'){
                ca++;
            }else if(s[i]=='b'){
                cb++;
            }else if(s[i]=='c'){
                cc++;
            }


                ans=min(ans, i+1+n-min(mp_a[max(0, k-ca)], min(mp_b[max(0, k-cb)], mp_c[max(0, k-cc)])));

        }

        return ans;


    }
};


     */


    //BINARY SEARCH ON Answer
    public int maximumTastinessOpt(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int left = 0;
        int right = price[n-1] - price[0];
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            boolean check = checkValid(mid, price, k);
            if(check){
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return ans;
    }

    private static boolean checkValid(int mid, int[] prices, int k){
        int n = prices.length;
        int j = 0;
        int len = 0;
        for (int i = 1; i < n; i++) {
            if(prices[i]-prices[j] >= mid){
                len++;
                j = i;
            }
        }

        if(len >= k){
            return true;
        }

        return false;
    }


    public static int takeCharacters(String s, int k) {
        int[] arr=new int[3];
        // count all the frq of string
        for(char ch:s.toCharArray()) arr[ch-'a']++;
        System.out.println(Arrays.toString(arr));

        // if total frq of any char is less than k return -1;
        if(arr[0]<k||arr[1]<k||arr[2]<k) return -1;
        int ans=arr[0]+arr[1]+arr[2];
        int st=0;

        for(char ch:s.toCharArray()){
            arr[ch-'a']--;

            // if any char length is less than k then increase start position
            if(arr[0]<k||arr[1]<k||arr[2]<k){
                //get the min ans
                ans=Math.min(arr[0]+arr[1]+arr[2]+1,ans);
                while(s.charAt(st)!=ch){
                    arr[s.charAt(st)-'a']++;
                    st++;
                }
                arr[ch-'a']++;
                st++;
            }
        }
        ans=Math.min(arr[0]+arr[1]+arr[2],ans);

        return ans;
    }

    public static int maximumTastiness(int[] price, int k) {
        Integer [][] dp = new Integer[price.length+1][k+1];
        return solve(price, 0, 0, k, new ArrayList<>(), dp);
    }

    private static int solve(int[] arr, int index, int curNum, int k, List<Integer> list, Integer[][] dp) {
        if (curNum == k) {
            int ans = twoMax(list);
            System.out.println(list+ " ans "+ans);
            return ans;
        }

        if (index >= arr.length) {
            return Integer.MIN_VALUE;
        }

        list.add(arr[index]);
        int pick = solve(arr, index +1, curNum+1,k ,list, dp);
        list.remove(list.size()-1);
        int notPick = solve(arr, index+1, curNum, k,list, dp);

        return dp[index][curNum] = Math.max(pick, notPick);
    }

    private static int twoMax(List<Integer> nums) {
        int n = nums.size();
        List<Integer> arr = new ArrayList<>(nums);
        Collections.sort(arr);
        int min =  Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.abs(arr.get(i)-arr.get(i-1)));
        }
        return min;
    }

    public static int closetTarget(String[] words, String target, int startIndex) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
        if (!hashSet.contains(target)) return -1;
        if (words[startIndex].equals(target)) return 0;
        int n = words.length;
        int right = (startIndex + 1) % n;
        int rightCount = 1;
        while (right != startIndex) {
            if (words[right].equals(target)) {
                break;
            }
            rightCount++;
            right = (right + 1) % n;
        }
        int leftCount = 1;
        int left = (startIndex - 1 + n) % n;
        while (left != startIndex) {
            if (words[left].equals(target)) {
                break;
            }
            leftCount++;
            left = (left - 1 + n) % n;
        }
        return Math.min(leftCount, rightCount);
    }
}
