package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class Board {

    private final PlayerMark[] squares = new PlayerMark[]{
            UNMARKED, UNMARKED, UNMARKED,
            UNMARKED, UNMARKED, UNMARKED,
            UNMARKED, UNMARKED, UNMARKED
    };

    private final int numberOfSquares = squares.length;

    public Board() {
    }

    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    public PlayerMark getSquare(int square) {
        return squares[square];
    }

    public void markSquare(int square, PlayerMark mark) throws SquareIsMarkedException {
        if (squares[square] == UNMARKED) {
            squares[square] = mark;
        }
        else {
            throw new SquareIsMarkedException();
        }
    }
}
