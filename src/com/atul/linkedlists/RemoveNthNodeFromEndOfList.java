package com.atul.linkedlists;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        String s1 = "12";
        String s2 = "198111";

        if (s1.length() > s2.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }

        s2 = new StringBuilder(s2).reverse().toString();
        s1 = new StringBuilder(s1).reverse().toString();
        int carry = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        //StringBuilder res = new StringBuilder();
        String res = "";
        for (int i = 0; i < n1; i++) {
            int sum = (s1.charAt(i) - '0') + (s2.charAt(i) - '0') + carry;
            res += ((char) (sum % 10 + '0'));
            System.out.println(res);
            carry = sum / 10;
        }
        //System.out.println(res.reverse());
        for (int i = n1; i < n2; i++) {
            int sum = (s2.charAt(i) - '0') + carry;
            res += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0) {
            res += (char) (carry + '0');
        }
        System.out.println(new StringBuilder(res).reverse());
        //System.out.println(res.reverse());
    }

}
