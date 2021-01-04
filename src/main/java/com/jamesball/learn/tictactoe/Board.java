package com.jamesball.learn.tictactoe;

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

    public void markSquare(int square, PlayerMark mark) throws SquareIsMarkedException {
        if (squares[square] == UNMARKED) {
            squares[square] = mark;
        }
        else {
            throw new SquareIsMarkedException();
        }
    }

    public Board copy() {
        Board boardCopy = new Board();

        for (int i = 0; i < squares.length; i++) {
            boardCopy.markSquare(i, this.getSquare(i));
        }

        return boardCopy;
    }
}
