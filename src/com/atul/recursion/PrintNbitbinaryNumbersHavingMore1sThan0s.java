package com.atul.recursion;

import java.util.ArrayList;

public class PrintNbitbinaryNumbersHavingMore1sThan0s {

    public static void main(String[] args) {
        NBitBinary(3);
    }

    public static ArrayList<String> NBitBinary(int N) {
        // code here
        N=4;
        String s = "";
        int noOf1s = 0;
        int noOf0s = 0;
        int curr = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(permutation(s, noOf1s, noOf0s, N , arrayList));
        return null;
    }

    public static ArrayList<String> permutation(String s, int noOf1s, int noOf0s, int n, ArrayList<String> arrayList){
        if (n==0){
            arrayList.add(s);
            return arrayList;
        }

        if(noOf1s == noOf0s){
            permutation(s+"1", noOf1s+1, noOf0s, n-1,  arrayList);
        }else if(noOf1s > noOf0s){
            permutation(s+"1", noOf1s+1, noOf0s, n-1,  arrayList);
            permutation(s+"0", noOf1s, noOf0s+1, n-1,  arrayList);
        }

        return arrayList;
    }
}
