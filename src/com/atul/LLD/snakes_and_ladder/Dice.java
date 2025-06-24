package com.atul.LLD.snakes_and_ladder;

import java.util.Random;

public class Dice {
    private static final int min = 1;
    private static final int max = 6;

    public int rollDice(){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
