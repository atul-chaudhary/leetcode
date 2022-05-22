package com.atul.strings;

public class ImplementIndexOf {
    public static void main(String[] args) {
        String a = "hello";
        String b = "ll";
        System.out.println(strStr(a, b));
    }

    public static int strStr(String haystack, String needle) {
        int alen = haystack.length();
        int blen = needle.length();
        if(blen > alen) return -1;
        int index = -1;
        if(alen > blen){
            for(int i=0;i<alen-blen+1;i++){
                if(haystack.charAt(i)==needle.charAt(0)) {
                    boolean isMatched = true;
                    for (int j = 0; j < blen; j++) {
                        if (needle.charAt(j) != haystack.charAt(i + j)) {
                            isMatched = false;
                            break;
                        }
                    }
                    if (isMatched) {
                        index = i;
                        break;
                    }
                }
            }
        }else{
            if(haystack.equals(needle)) return 0;
        }
        return index;
    }
}
