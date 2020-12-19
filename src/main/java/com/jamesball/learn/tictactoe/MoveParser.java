package com.jamesball.learn.tictactoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveParser {

    private final Pattern pattern;

    public MoveParser(Pattern pattern) {
        this.pattern = pattern;
    }

    public String parse(String input) throws InvalidInputException {
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return input;
        }

        throw new InvalidInputException();
    }
}
