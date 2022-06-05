package com.atul.recursion;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(30,1));
    }


    //first using iterative
    public static int kthGrammar(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        for(int i=2;i<=n;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j) =='0'){
                    temp.append("01");
                }else{
                    temp.append("10");
                }
            }
            s = temp;
        }
        System.out.println(s.toString());
        return s.charAt(k-1)-'0';
    }
}
