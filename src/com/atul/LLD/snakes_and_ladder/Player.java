package com.atul.LLD.snakes_and_ladder;

public class Player {
    String name;
    int playerId;
    String color;
    int score;

    public Player(String name, int playerId, String color) {
        this.name = name;
        this.playerId = playerId;
        this.color = color;
    }

    public Player(String name, int playerId, String color, int score) {
        this.name = name;
        this.playerId = playerId;
        this.color = color;
        this.score = score;
    }
}
