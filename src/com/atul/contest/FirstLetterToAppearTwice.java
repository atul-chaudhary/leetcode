package com.atul.contest;

import java.util.HashMap;
import java.util.Map;

public class FirstLetterToAppearTwice {

    static class Pair{
        String cus;
        int rat;

        Pair(String cus, int rat){
            this.cus = cus;
            this.rat = rat;
        }
    }

    public static void main(String[] args) {
        String[] food={"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cus = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] art = {9,12,16,15,14,7};
        FoodRatings(food, cus, art);
        System.out.println(highestRated("japanese"));
    }

    static HashMap<String, Pair> map = new HashMap<>();
    public static void FoodRatings(String[] food, String[] cuisines, int[] ratings) {
        for(int i=0;i<food.length;i++){
            map.put(food[i], new Pair(cuisines[i], ratings[i]));
        }

    }

    public void changeRating(String food, int newRating) {
        Pair p = map.get(food);
        map.put(food, new Pair(p.cus, newRating));
    }

    public static String highestRated(String cuisine) {
        String food = null;
        int high = 0;
        for(Map.Entry<String, Pair> e : map.entrySet()){
            Pair p = e.getValue();
            if(p.cus.equals(cuisine) && p.rat >= high){
                if(p.rat == high){
                    int i = food.compareTo(e.getKey());
                    if(i > 0){
                        food = e.getKey();
                    }
                }else{
                    food = e.getKey();
                }
                high = e.getValue().rat;
            }

        }
        return food;
    }
}
