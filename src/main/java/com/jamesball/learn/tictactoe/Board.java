package com.jamesball.learn.tictactoe;

import java.util.Arrays;

public class Board {

    private final BoardSquare[] squares = new BoardSquare[]{
            new BoardSquare("a1"), new BoardSquare("b1"), new BoardSquare("c1"),
            new BoardSquare("a2"), new BoardSquare("b2"), new BoardSquare("c2"),
            new BoardSquare("a3"), new BoardSquare("b3"), new BoardSquare("c3")
    };

    public Board() {
    }

    public BoardSquare getSquare(String coordinate) throws InvalidCoordinateException {
        return Arrays.stream(squares)
                .filter(square -> square.getId().equals(coordinate))
                .findFirst()
                .orElseThrow(InvalidCoordinateException::new);
    }

    public String[] getMarks() {
        return Arrays.stream(squares)
                .map(BoardSquare::getMark)
                .toArray(String[]::new);
    }
}
