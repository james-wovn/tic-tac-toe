package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.GameState.*;

public class BoardEvaluator {

    private Board board;

    public BoardEvaluator(Board board) {
        this.board = board;
    }

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

    public GameState evaluate() {
        if (isWin()) {
            return WIN;
        }
        else if (isDraw()) {
            return DRAW;
        }
        else {
            return IN_PLAY;
        }
    }

    private boolean isWin() {
        boolean isWin;

        for (int[] combination : COMBINATIONS) {
            isWin = true;

            PlayerMark firstMark = board.getMark(combination[0]);

            if (firstMark == null) {
                continue;
            }

            for (int position = 1; position < combination.length && isWin; position++) {
                isWin = board.getMark(combination[position]) == firstMark;
            }

            if (isWin) {
                return true;
            }
        }

        return false;
    }

    private boolean isDraw() {
        for (int square = 0; square < board.getSize(); square++) {
            if (!board.isMarked(square)) {
                return false;
            }
        }

        return true;
    }
}
