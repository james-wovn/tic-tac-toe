package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.UNMARKED;

public class BoardEvaluator {

    private static final int[][] COMBINATIONS = new int[][]{
            // rows
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            // columns
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            // diagonals
            {0, 4, 8},
            {2, 4, 6}
    };

    public BoardEvaluator() {
    }

    public GameState evaluate(Board board) {
        if (isWin(board)) {
            return WON;
        }
        else if (isDraw(board)) {
            return DRAWN;
        }

        return IN_PROGRESS;
    }

    private boolean isWin(Board board) {
        for (int[] combination : COMBINATIONS) {
            if (isCombinationComplete(board, combination)) {
                return true;
            }
        }

        return false;
    }

    private boolean isDraw(Board board) {
        for (int square = 0; square < board.getNumberOfSquares(); square++)
            if (board.getSquare(square) == UNMARKED) {
                return false;
        }

        return true;
    }

    private boolean isCombinationComplete(Board board, int[] combination) {
        PlayerMark firstMark = board.getSquare(combination[0]);

        for (int square : combination) {
            PlayerMark mark = board.getSquare(square);
            if (mark == UNMARKED || mark != firstMark) {
                return false;
            }
        }

        return true;
    }
}
