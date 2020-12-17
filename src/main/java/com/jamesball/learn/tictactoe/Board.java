package com.jamesball.learn.tictactoe;

public class Board {

    private static final int SIZE = 3;

    private static final String[][] board = new String[SIZE][SIZE];

    static {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                board[row][column] = " ";
            }
        }
    }

    public Board() {
    }

    public String[][] getBoard() {
        return board;
    }

    public String getMarkAtBoardSpace(int row, int column) {
        return board[row][column];
    }

    @Override
    public String toString() {
        return """
                    0   1   2
                  +---+---+---+
                0 | %s | %s | %s |
                  +---+---+---+
                1 | %s | %s | %s |
                  +---+---+---+
                2 | %s | %s | %s |
                  +---+---+---+
                """.formatted(getMarkAtBoardSpace(0,0),
                getMarkAtBoardSpace(0,1),
                getMarkAtBoardSpace(0,2),
                getMarkAtBoardSpace(1,0),
                getMarkAtBoardSpace(1,1),
                getMarkAtBoardSpace(1,2),
                getMarkAtBoardSpace(2,0),
                getMarkAtBoardSpace(2,1),
                getMarkAtBoardSpace(2,2)
        );
    }
}
