package com.jamesball.learn.tictactoe;

public class Board {

    private static final int SIZE = 3;
    private static final String OUTPUT_FORMAT = """
                    0   1   2
                  +---+---+---+
                0 | %s | %s | %s |
                  +---+---+---+
                1 | %s | %s | %s |
                  +---+---+---+
                2 | %s | %s | %s |
                  +---+---+---+
                """;

    private final Square[][] board = new Square[SIZE][SIZE];

    {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                board[row][column] = new Square();
            }
        }
    }

    public Board() {
    }

    public Square[][] getBoard() {
        return board;
    }

    public Square getSquare(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    @Override
    public String toString() {
        return OUTPUT_FORMAT.formatted(
                getSquare(new Position(0, 0)).getMark(),
                getSquare(new Position(0, 1)).getMark(),
                getSquare(new Position(0, 2)).getMark(),
                getSquare(new Position(1, 0)).getMark(),
                getSquare(new Position(1, 1)).getMark(),
                getSquare(new Position(1, 2)).getMark(),
                getSquare(new Position(2, 0)).getMark(),
                getSquare(new Position(2, 1)).getMark(),
                getSquare(new Position(2, 2)).getMark()
        );
    }
}
