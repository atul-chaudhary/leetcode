package com.atul.LLD.snakes_and_ladder;

import java.util.ArrayDeque;
import java.util.List;

public class GameBoard {
    ArrayDeque<Player> players;
    Board board;
    Dice dice;

    public GameBoard(List<Player> players, Board board, Dice dice) {
        this.players = new ArrayDeque<>();
        this.players.addAll(players);
        this.board = board;
        this.dice = dice;
    }


    public void startGame() {
        int currMaxScore = 0;

        while (currMaxScore <= 100) {
            Player currentPlayer = players.pollFirst();
            System.out.println("Current Player Playing is " + currentPlayer.name);
            int numberFromDice = dice.rollDice();
            int[] cellRowAndCol = Utils.calculateRowAndCol(numberFromDice);
            System.out.println("Player " + currentPlayer.name + "is has rolled the dice and number is " + numberFromDice);

            int row = cellRowAndCol[0];
            int col = cellRowAndCol[1];

            int currentCellNumber = currentPlayer.score + numberFromDice;
            System.out.println("Player has moved to position" + currentCellNumber);

            if (board.cells[row][col].isLadderOpening) {
                System.out.println("Since current number has Ladder player moved to" + board.cells[row][col].end);
                currentPlayer.score = board.cells[row][col].end;
            }

            if (board.cells[row][col].isLadderOpening) {
                System.out.println("Since current number has snake player moved to" + board.cells[row][col].end);
                currentPlayer.score = board.cells[row][col].end;
            }

            currMaxScore = Math.max(currMaxScore, currentPlayer.score);

            players.addLast(currentPlayer);

            if(currentPlayer.score == 100) {
                System.out.println("Player "+ currentPlayer.name + " has won the game");
                break;
            }
        }
    }
}
