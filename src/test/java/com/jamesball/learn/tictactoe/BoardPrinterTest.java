package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardPrinterTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private BoardPrinter printer;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));

        printer = new BoardPrinter(System.out);
    }

    @Test
    public void whenPrinted_thenOutputIsCorrect() {
        String[] marks = new String[]{"X", null, null, null, "O", null, null, null, "X"};

        printer.print(marks);

        assertEquals("""
                    a   b   c
                  +---+---+---+
                1 | X |   |   |
                  +---+---+---+
                2 |   | O |   |
                  +---+---+---+
                3 |   |   | X |
                  +---+---+---+
                """, output.toString());
    }
}
