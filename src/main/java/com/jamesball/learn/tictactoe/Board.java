package com.jamesball.learn.tictactoe;

public class Board {

    private static final int NUMBER_OF_SQUARES = 9;

    private final PlayerMark[] board = new PlayerMark[NUMBER_OF_SQUARES];

    public int getSize() {
        return board.length;
    }

    public PlayerMark[] getBoard() {
        return board;
    }

    public PlayerMark getMark(int square) {
        return board[square];
    }

    public boolean isMarked(int square) {
        return board[square] != null;
    }

    public void mark(Move move) {
        board[move.getSquare()] = move.getMark();
    }
}
