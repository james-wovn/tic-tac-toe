package com.jamesball.learn.tictactoe;

public class Board {

    private final PlayerMark[] board = new PlayerMark[9];

    public Board() {
    }

    public Board(PlayerMark[] board) {
        System.arraycopy(board, 0, this.board, 0, this.board.length);
    }

    public int getSize() {
        return board.length;
    }

    public PlayerMark[] getBoard() {
        PlayerMark[] copy = new PlayerMark[this.board.length];
        System.arraycopy(this.board, 0, copy, 0, copy.length);
        return copy;
    }

    public PlayerMark getMark(int square) {
        return board[square];
    }

    public boolean isMarked(int square) {
        return board[square] != null;
    }

    public void addMove(Move move) {
        board[move.getSquare()] = move.getMark();
    }

    public Board clone() {
        return new Board(this.board);
    }
}
