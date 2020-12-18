package com.jamesball.learn.tictactoe;

public class Square {

    private String mark = " ";

    public Square() {
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) throws IsMarkedException {
        if (this.mark.equals(" ")) {
            this.mark = mark;
        }
        else {
            throw new IsMarkedException();
        }
    }
}
