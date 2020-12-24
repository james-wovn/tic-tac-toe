package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardPrinterTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private BoardPrinter printer;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));

        printer = new BoardPrinter(System.out);
    }

    @Test
    public void whenPrinted_thenFormatIsCorrect() {
        Board board = mock(Board.class);

        board.setBoard();

        when(board.getBoard()).thenReturn(new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '});

        printer.print(board.getBoard());

        assertEquals("""
                -----+-----+-----
                |    |     |    |
                -----+-----+-----
                |    |     |    |
                -----+-----+-----
                |    |     |    |
                -----+-----+-----
                """, output.toString());
    }
}
