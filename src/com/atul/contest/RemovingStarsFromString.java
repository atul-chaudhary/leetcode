package com.atul.contest;

public class RemovingStarsFromString {
    public static void main(String[] args) {
        String s = "erase*****";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
        int n = s.length();
        int star = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '*'){
                star++;
            }else{
                if(star == 0){
                    sb.append(s.charAt(i));
                }else{
                    star--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
