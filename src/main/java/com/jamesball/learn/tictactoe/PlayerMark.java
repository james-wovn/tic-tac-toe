package com.jamesball.learn.tictactoe;

public enum PlayerMark {

    UNMARKED(' '),
    PLAYER_1('X'),
    PLAYER_2('O');

    PlayerMark(char mark) {
        this.mark = mark;
    }

    public char mark;

    public char getMark() {
        return mark;
    }
}
