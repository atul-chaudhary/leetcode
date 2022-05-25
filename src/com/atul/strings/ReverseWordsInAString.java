package com.atul.strings;

public class ReverseWordsInAString {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        String ans = "";
        int len = s.length();
        int i=len-1;
        while(i >= 0){
            while(i>=0 && s.charAt(i) == ' ') i--;
            int j = i;
            while(i >=0 && s.charAt(i) == ' ') i--;

            if(s.isEmpty()){
                ans = ans.concat(s.substring(i+1,j+1));
            }else{
                ans = ans.concat(" "+s.substring(i+1, j+1));
            }
        }
        return ans;
    }

    public static String reverseWords11(String s) {
        StringBuilder res = new StringBuilder();
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ') continue;
            int end = start;
            while (start >= 0 && s.charAt(start) != ' ') start--;
            res.append(s.substring(start + 1, end + 1)).append(" ");
        }
        return res.toString().trim();
    }
}
