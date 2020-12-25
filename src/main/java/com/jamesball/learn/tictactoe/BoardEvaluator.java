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
            if (isCompleteCombination(board, combination)) {
                return true;
            }
        }

        return false;
    }

    private boolean isDraw(Board board) {
        for (int square = 0; square < Board.getSize(); square++) {
            if (board.getMark(square) == UNMARKED) {
                return false;
            }
        }

        return true;
    }

    private boolean isCompleteCombination(Board board, int[] combination) {
        for (int square : combination) {
            if (board.getMark(square) != board.getMark(combination[0])) {
                return false;
            }
        }

        return true;
    }
}
