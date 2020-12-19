package com.jamesball.learn.tictactoe;

import java.io.PrintStream;
import java.util.Optional;

public class BoardPrinter {

    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(String[] marks) {
        String outputFormat = """
                    a   b   c
                  +---+---+---+
                1 | %s | %s | %s |
                  +---+---+---+
                2 | %s | %s | %s |
                  +---+---+---+
                3 | %s | %s | %s |
                  +---+---+---+
                """;

        out.print(outputFormat.formatted(
                formatMark(marks[0]), formatMark(marks[1]), formatMark(marks[2]),
                formatMark(marks[3]), formatMark(marks[4]), formatMark(marks[5]),
                formatMark(marks[6]), formatMark(marks[7]), formatMark(marks[8])
        ));
    }

    private String formatMark(String mark) {
        Optional<String> optionalMark = Optional.ofNullable(mark);
        if (optionalMark.isEmpty()) {
            return " ";
        }
        return mark;
    }
}
