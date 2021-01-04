package com.jamesball.learn.tictactoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveParser {

    private static final int OFFSET = 1;

    private final Pattern pattern;

    public MoveParser(Pattern pattern) {
        this.pattern = pattern;
    }

    public int parse(String input) throws InvalidInputException {
        input = input.trim();

        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return Integer.parseInt(input) - OFFSET;
        }

        throw new InvalidInputException();
    }
}
