package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class Board {

    private static final int SIZE = 9;

    private PlayerMark[] board;

    public Board() {
    }

    public static int getSize() {
        return SIZE;
    }

    public PlayerMark[] getBoard() {
        return board;
    }

    public void setBoard() {
        board = new PlayerMark[SIZE];
        for (int square = 0; square < SIZE; square++) {
            board[square] = UNMARKED;
        }
    }

    public PlayerMark getMark(int square) {
        return board[square];
    }

    public void setMark(int square, PlayerMark mark) throws SquareIsMarkedException {
        if (board[square] == UNMARKED) {
            board[square] = mark;
        }
        else {
            throw new SquareIsMarkedException();
        }
    }
}
