package com.jamesball.learn.tictactoe;

public class Board {

    private static final char UNMARKED_SQUARE = ' ';

    private char[] board;

    public Board() {
    }

    public char[] getBoard() {
        return board;
    }

    public void setBoard() {
        final int number_of_squares = 9;

        board = new char[number_of_squares];
        for (int square = 0; square < number_of_squares; square++) {
            board[square] = UNMARKED_SQUARE;
        }
    }

    public char getMark(int square) {
        return board[square];
    }

    public void setMark(int square, char mark) throws SquareIsMarkedException {
        if (isUnmarked(square)) {
            board[square] = mark;
        }
        else {
            throw new SquareIsMarkedException();
        }
    }

    private boolean isUnmarked(int square) {
        return board[square] == UNMARKED_SQUARE;
    }
}
