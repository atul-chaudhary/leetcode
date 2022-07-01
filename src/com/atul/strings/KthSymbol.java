package com.atul.strings;

public class KthSymbol {
    public static void main(String[] args) {
        int n=3;
        String s = "0";
        int count = 0;
        while(n>1){
            String result = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0'){
                    result+="01";
                }else{
                    result+="10";
                }
            }
            n--;
            //count++;
            s = result;
        }
        System.out.println(s);
    }
}
