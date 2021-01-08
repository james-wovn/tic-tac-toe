package com.jamesball.learn.tictactoe;

import java.util.Arrays;

import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class Board {

    private final PlayerMark[] squares = new PlayerMark[]{
            UNMARKED, UNMARKED, UNMARKED,
            UNMARKED, UNMARKED, UNMARKED,
            UNMARKED, UNMARKED, UNMARKED
    };

    public Board() {
    }

    public PlayerMark[] getSquares() {
        return squares;
    }

    public PlayerMark getSquare(int square) {
        return squares[square];
    }

    public void markSquare(Move move) {
        squares[move.getSquare()] = move.getMark();
    }

    public int[] unmarkedSquares() {
        int[] unmarkedSquares = new int[]{};

        for (int square = 0; square < squares.length; square++) {
            if (isUnmarked(square)) {
                int[] unmarkedSquaresCopy = new int[unmarkedSquares.length + 1];
                unmarkedSquaresCopy[unmarkedSquares.length] = square;
                unmarkedSquares = unmarkedSquaresCopy;
            }
        }

        return unmarkedSquares;
    }

    public boolean isUnmarked(int square) {
        return squares[square] == UNMARKED;
    }
}
