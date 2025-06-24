package com.atul.LLD.snakes_and_ladder;

public class Cell {
    boolean isSnakeOpening;
    boolean isLadderOpening;
    int start;
    int end;

    public Cell(boolean isSnakeOpening, boolean isSnakeEnding, boolean isLadderOpening, boolean isLadderEnding, int start, int end) {
        this.isSnakeOpening = isSnakeOpening;
        this.isLadderOpening = isLadderOpening;
        this.start = start;
        this.end = end;
    }

    //TODO we can use Builder Design patter as well, Since Object is becoming larger
}
