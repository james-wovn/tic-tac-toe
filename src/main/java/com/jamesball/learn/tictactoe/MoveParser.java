package com.jamesball.learn.tictactoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveParser {

    private final Pattern pattern = Pattern.compile("^[1-9]$");

    public boolean isParsable(String input) {
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    public int parse(String square) {
        return Integer.parseInt(square) - 1;
    }
}
