package com.atul.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TheEmployeeThatWorkedLongestTask {
    public static void main(String[] args) {
        int[][] logs = {{110,5},{360,7},{48,8},{286,10},{167,12},{110,13},{221,18}};
        int n = 26;
        //System.out.println(hardestWorkerOpt(n, logs));
        System.out.println(2^2);
    }
    public static int hardestWorkerOpt(int n, int[][] logs) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if(i==0){
                map.put(logs[i][0], logs[0][1]);
            }else{
                int val = logs[i][1] - logs[i-1][1];
                if(map.containsKey(logs[i][0])){
                    map.put(logs[i][0], Math.max(map.get(logs[i][0]) ,val));
                }else {
                    map.put(logs[i][0], val);
                }
            }
        }
        System.out.println(map);
        int key = -1;
        int val = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > val){
                val = entry.getValue();
                key = entry.getKey();
            }else if(entry.getValue() == val){
                key = Math.min(entry.getKey(), key);
            }
        }
        return key;
    }

    public static int hardestWorker(int n, int[][] logs) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<logs.length;i++){
            if(i==0){
                map.put(logs[i][1], logs[i][0]);
            }else{
                map.put(logs[i][1] - logs[i-1][1], logs[i][0]);
            }
        }
        System.out.println(map);
        int i=0;
        int result = -1;
        int val = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(i==0){
                result = entry.getValue();
                val = entry.getKey();
                i++;
            }else{
                if(entry.getKey() == val){
                    result = Math.min(result, entry.getValue());
                }else{
                    break;
                }
            }
        }
        return result;
    }
}
