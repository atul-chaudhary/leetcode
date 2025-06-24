package com.atul.LLD.snakes_and_ladder;

import java.util.Scanner;

public class Board {
    Cell[][] cells;

    public Board(int size) {
        cells = new Cell[size][size];
    }

    public void addSnake() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide Snake input for startCell and End Cell in space separated");

        String[] input = scanner.next().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        int[] startRowsAndCols = Utils.calculateRowAndCol(start);
        cells[startRowsAndCols[0]][startRowsAndCols[1]] = new Cell(true, false, false, false, start, end);

        int[] EndRowAndCol = Utils.calculateRowAndCol(end);
        cells[EndRowAndCol[0]][EndRowAndCol[1]] = new Cell(false, true, false, false, start, end);
    }

    public void addLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide Ladder input for startCell and End Cell in space separated");
        String[] input = scanner.next().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        int[] startRowsAndCols = Utils.calculateRowAndCol(start);
        cells[startRowsAndCols[0]][startRowsAndCols[1]] = new Cell(true, false, false, false, start, end);

        int[] EndRowAndCol = Utils.calculateRowAndCol(end);
        cells[EndRowAndCol[0]][EndRowAndCol[1]] = new Cell(false, true, false, false, start, end);
    }
}
