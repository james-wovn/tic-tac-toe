package com.jamesball.learn.tictactoe;

public class Move {

    private final PlayerMark mark;
    private final int square;

    public Move(PlayerMark mark, int square) {
        this.mark = mark;
        this.square = square;
    }

    public PlayerMark getMark() {
        return mark;
    }

    public int getSquare() {
        return square;
    }
}
