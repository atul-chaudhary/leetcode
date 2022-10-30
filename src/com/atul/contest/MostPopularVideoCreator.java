package com.atul.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularVideoCreator {
    public static void main(String[] args) {
        String[] s = {"alice","alice","alice"};
        int [] view = {1,2,2};
        String[] arr = {"a","b","c"};
        System.out.println(mostPopularCreator(s, arr, view));
    }

    static class Pair{
        String id;
        int view;
        int popu;

        public Pair(String id, int view, int popu) {
            this.id = id;
            this.view = view;
            this.popu = popu;
        }
    }
    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Pair> map = new HashMap<>();
        int n = views.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(creators[i])){
                Pair p = map.get(creators[i]);
                if(views[i] > p.view){
                    p.id = ids[i];
                    p.view = views[i];
                }else if(p.view == views[i]){
                    p.id = p.id.compareTo(ids[i]) > 0 ? ids[i] : p.id;
                }
                p.popu+=views[i];
                map.put(creators[i], p);
            }else{
                map.put(creators[i], new Pair(ids[i], views[i], views[i]));
            }
        }
        int max = -1;
        for(Map.Entry<String, Pair> entry : map.entrySet()){
            max = Math.max(max, entry.getValue().popu);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, Pair> entry : map.entrySet()){
            if(entry.getValue().popu == max) {
                List<String> temp = new ArrayList<>();
                temp.add(entry.getKey());
                temp.add(entry.getValue().id);
                result.add(temp);
            }
        }
        return result;
    }
}
