package com.atul.greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String[] arr = {"mm", "mm", "yb", "by", "bb", "bm", "ym", "mb", "yb", "by", "mb", "mb", "bb", "yb", "by", "bb", "yb", "my", "mb", "ym"};
        System.out.println(longestPalindrome2(arr));
    }


    public static int longestPalindrome2(String[] words) {
        HashMap<String,Integer> hm=new HashMap<>();
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            if(hm.containsKey(words[i]))
                hm.put(words[i],hm.get(words[i])+1);
            else
                hm.put(words[i],1);
        }
        System.out.println(hm);
        for(Map.Entry m: hm.entrySet())
        {
            String key=(String)m.getKey();
            int val=(int)m.getValue();
            String rev=reverse(key);
            if(hm.containsKey(rev))
            {
                if(rev.equals(key))
                {
                    int y=hm.get(rev);
                    if(y%2!=0)
                        y--;
                    count+=(2*y);
                    hm.replace(rev,hm.get(rev)-y);
                }
                else
                {
                    int min=Math.min(val,hm.get(rev));
                    count+=(4*min);
                    hm.replace(key,val-min);
                    hm.replace(rev,hm.get(rev)-min);
                }
            }

        }
        for(Map.Entry m: hm.entrySet())
        {
            String key=(String)m.getKey();
            int val=(int)m.getValue();
            if(key.charAt(0)==key.charAt(1) && val>0)
            {
                count+=2;
                break;
            }
        }
        return count;
    }
    static String reverse(String s)
    {
        String ans="";
        for(int i=1;i>=0;i--)
            ans+=s.charAt(i);

        return ans;
    }

    public static int longestPalindromeOpt(String[] words) {
        HashMap<String, Integer> m = new HashMap<>();
        int unpaired = 0, ans = 0;
        for (String w: words) {
            if (!m.containsKey(w)) m.put(w, 0);
            if (w.charAt(0) == w.charAt(1)) {
                if (m.get(w) > 0) {
                    unpaired--;
                    m.put(w, m.get(w) - 1);
                    ans += 4;
                }
                else {
                    m.put(w, m.get(w) + 1);
                    unpaired++;
                }
            }
            else {
                String rev = Character.toString(w.charAt(1)) +
                        Character.toString(w.charAt(0));
                if (m.containsKey(rev) && m.get(rev) > 0) {
                    ans += 4;
                    m.put(rev, m.get(rev) - 1);
                }
                else m.put(w, m.get(w) + 1);
            }

        }
        if (unpaired > 0) ans += 2;
        return ans;
    }

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        System.out.println(map);
        int count = 0;
        int n = words.length;
        boolean odd = false;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String str = entry.getKey();
            String opp = str.charAt(1) + "" +str.charAt(0);
            if(str.charAt(1) == str.charAt(0) && map.get(str) %2==0){
                count+=map.get(str)*2;
            }else if(str.charAt(1) == str.charAt(0) && map.get(str) % 2 == 1){
                if(odd){
                    count+=(map.get(str)-1)*2;
                }else{
                    count+=map.get(str)*2;
                }
                odd = true;
            }else if(str.charAt(1) != str.charAt(0) && map.containsKey(str) && map.get(str) >= 1 &&
                    map.containsKey(opp) && map.get(opp) >= 1){
                count+=4;
                map.put(str, map.get(str)-1);
                map.put(opp, map.get(opp)-1);
            }
        }
        return count;
    }
}
