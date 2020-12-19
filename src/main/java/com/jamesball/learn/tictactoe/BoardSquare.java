package com.jamesball.learn.tictactoe;

import java.util.Optional;

public class BoardSquare {

    private final String id;

    private String mark;

    public BoardSquare(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) throws MarkIsNotEmptyException {
        if (isEmpty()) {
            this.mark = mark;
        }
        else {
            throw new MarkIsNotEmptyException();
        }
    }

    private boolean isEmpty() {
        Optional<String> optionalMark = Optional.ofNullable(this.mark);

        return optionalMark.isEmpty();
    }
}
