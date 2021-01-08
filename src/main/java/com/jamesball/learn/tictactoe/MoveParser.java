package com.jamesball.learn.tictactoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveParser {

    private static final int indexOffset = 1;
    private static final Pattern pattern = Pattern.compile("^[0-9]$");

    private Board board;

    public MoveParser(Board board) {
        this.board = board;
    }

    public boolean validate(String input) {
        return isSingleDigitNaturalNumber(input) && isUnmarked(input);
    }

    public Move parse(String input, PlayerMark mark) {
        int square = parseToSquare(input);

        return new Move(square, mark);
    }

    private boolean isSingleDigitNaturalNumber(String input) {
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private boolean isUnmarked(String input) {
        int square = parseToSquare(input);

        return board.isUnmarked(square);
    }

    private int parseToSquare(String input) {
        return Integer.parseInt(input) - indexOffset;
    }
}
