package com.jamesball.learn.tictactoe;

import java.util.Arrays;

public class Board {

    private PlayerMark[] board = new PlayerMark[9];

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

    public void setBoard(PlayerMark[] board) {
        this.board = board;
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

    public Board rotate() {
        final PlayerMark[] rotatedBoard = new PlayerMark[board.length];

        // Transpose top row to right column
        rotatedBoard[2] = board[0];
        rotatedBoard[5] = board[1];
        rotatedBoard[8] = board[2];

        // Transpose middle row to middle column
        rotatedBoard[1] = board[3];
        rotatedBoard[4] = board[4];
        rotatedBoard[7] = board[5];

        // Transpose bottom row to left column
        rotatedBoard[0] = board[6];
        rotatedBoard[3] = board[7];
        rotatedBoard[6] = board[8];

        return new Board(rotatedBoard);
    }

    public Board reflect() {
        final PlayerMark[] reflectedBoard = new PlayerMark[board.length];

        reflectedBoard[2] = board[0];
        reflectedBoard[1] = board[1];
        reflectedBoard[0] = board[2];

        reflectedBoard[5] = board[3];
        reflectedBoard[4] = board[4];
        reflectedBoard[3] = board[5];

        reflectedBoard[8] = board[6];
        reflectedBoard[7] = board[7];
        reflectedBoard[6] = board[8];

        return new Board(reflectedBoard);
    }

    public boolean isSymmetrical(Board boardToCompare) {
        final int rotations = 3;

        if (equals(boardToCompare) || equals(boardToCompare.reflect())) {
            return true;
        }

        // Rotate the board along each face to check if it is symmetrical
        for (int i = 0; i < rotations; i++) {
            Board rotatedBoard = boardToCompare.rotate();

            if (equals(rotatedBoard) || equals(rotatedBoard.reflect())) {
                return true;
            }

            boardToCompare = rotatedBoard;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Arrays.equals(board, board1.board);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(board);
    }
}
