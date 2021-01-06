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

    public void markSquare(Move move) throws SquareIsMarkedException {
        if (isUnmarked(move.getSquare())) {
            squares[move.getSquare()] = move.getMark();
        }
        else {
            throw new SquareIsMarkedException();
        }
    }

    public Move[] availableMoves() {
        Move[] availableMoves = new Move[]{};

        for (int square = 0; square < squares.length; square++) {
            if (isUnmarked(square)) {
                Move availableMove = new Move();

                availableMove.setSquare(square);

                Move[] availableMovesCopy = new Move[availableMoves.length + 1];
                availableMovesCopy[availableMoves.length] = availableMove;
                availableMoves = availableMovesCopy;
            }
        }

        return availableMoves;
    }

    private boolean isUnmarked(int square) {
        return squares[square] == UNMARKED;
    }
}
