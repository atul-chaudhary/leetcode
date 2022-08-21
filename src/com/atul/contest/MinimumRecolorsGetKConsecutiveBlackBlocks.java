package com.atul.contest;

public class MinimumRecolorsGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors(s, k));
    }

    public static int minimumRecolors(String blocks, int k) {
        int count = Integer.MAX_VALUE;
        int cur = 0;
        int num = 0;
        for (int i = 0; i < blocks.length(); i++) {
            cur++;
            if(blocks.charAt(i)== 'W'){
                num++;
            }
            if(cur == k){
                count = Math.min(count, num);
                if(blocks.charAt(i-(k-1)) == 'W'){
                    num--;
                }
                cur--;
            }
        }
        return count;
    }
}
