package com.jamesball.learn.tictactoe;

public class Move {

    private int square;
    private PlayerMark mark;

    public Move(int square, PlayerMark mark) {
        this.square = square;
        this.mark = mark;
    }

    public int getSquare() {
        return square;
    }

    public PlayerMark getMark() {
        return mark;
    }

    public void setMark(PlayerMark mark) {
        this.mark = mark;
    }
}
