package com.atul.contest;

public class NumberOfValidClockTimes {
    public static void main(String[] args) {
        String s  = "?4:22";
        System.out.println(countTime(s));
    }

    public static int countTime(String time) {
        String[] string = time.split(":");
        char[] hrs = string[0].toCharArray();
        char[] min = string[1].toCharArray();
        int result  = 1;
        if(hrs[0] == '?' && hrs[1]=='?'){
            result  = 24;
        }else if(hrs[0] != '?' && hrs[1] == '?'){
            if(hrs[0]-'0' <= 1) {
                result = 10;
            }else result = 4;
        }else if(hrs[0] == '?' && hrs[1] != '?'){
            if(hrs[1]-'0' >= 4){
                result = 2;
            }else {
                result = 3;
            }
        }
        System.out.println(result);
        int res_min = 1;
        if(min[0]=='?' && min[1]  == '?'){
            res_min = 60;
        }else if(min[0] != '?' && min[1] == '?'){
            res_min = 10;
        }else if(min[0] == '?'){
            res_min = 6;
        }

        System.out.println(res_min);
        return res_min*result;
    }
}
