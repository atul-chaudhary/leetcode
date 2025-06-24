package com.atul.LLD.tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Atul", 'X');
        User user2 = new User("Arush", 'O');

        List<User> playlist = Arrays.asList(user1, user2);
        Board board = new Board(3);
        BoardGame boardGame = new BoardGame(playlist, board);
        boardGame.startGame();
    }
}

class BoardGame {
    ArrayDeque<User> players;
    Board board;
    Scanner scanner;

    public BoardGame(List<User> playerList, Board board) {
        players = new ArrayDeque<>();
        players.addAll(playerList);
        this.board = board;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        int n = board.board.length;
        int totalCount = 0;
        while (totalCount < n * n) {
            User currentUser = players.poll();
            InputUser currentUserInput = takeInput(currentUser);
            boolean isSet = board.setInput(currentUserInput, currentUser.symbol);
            if (isSet == false) {
                players.addFirst(currentUser);
                continue;
            }
            players.addLast(currentUser);
            board.printBoard();
            boolean isWon = checkIfGameWon(board, currentUser);
            if (isWon) break;
            totalCount++;
        }
    }

    private boolean checkIfGameWon(Board board, User user) {
        int n = board.board.length;
        char symbolToCheck = user.symbol;
        //row check
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (board.board[i][j] != null && board.board[i][j] == symbolToCheck) {
                    count++;
                }
            }

            if (count == n) {
                System.out.println(user.name + " has won the game");
            }
        }


        //column check
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (board.board[i][j] != null && board.board[i][j] == symbolToCheck) {
                    count++;
                }
            }
            if (count == n) {
                System.out.println(user.name + "has won the game");
                return true;
            }
        }


        //diagonal check
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (board.board[i][j] != null && board.board[i][j] == symbolToCheck) {
                        count++;
                    }
                }
            }
            if (count == 3) {
                System.out.println(user.name + "has won the game");
                return true;
            }
        }

        int col = n - 1;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (board.board[i][col] != null && board.board[i][col] == symbolToCheck) {
                count++;
            }
            col--;
        }
        if (count == n) {
            System.out.println(user.name + " has won the game");
            return true;
        }
        return false;
    }


    private InputUser takeInput(User user) {
        System.out.println("Enter input " + user.name);
        String[] arr = scanner.nextLine().split(" ");
        return new InputUser(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
    }

}

class Board {
    Character[][] board;

    Board(int n) {
        this.board = new Character[n][n];
    }

    public boolean setInput(InputUser inputUser, char symbol) {
        if (isInputValid(inputUser)) {
            board[inputUser.x][inputUser.y] = symbol;
            return true;
        } else {
            return false;
        }
    }

    private boolean isInputValid(InputUser inputUser) {
        if (board[inputUser.x][inputUser.y] != null) {
            return false;
        }
        return true;
    }

    public void printBoard() {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
                if (j < n - 1) {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }
}

class InputUser {
    int x;
    int y;

    public InputUser(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class User {
    String name;
    char symbol;

    public User(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}


