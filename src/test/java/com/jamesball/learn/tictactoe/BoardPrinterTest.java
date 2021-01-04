package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardPrinterTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private Board board;
    private BoardPrinter printer;

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(out));

        board = mock(Board.class);
        printer = new BoardPrinter(System.out);
    }

    @Test
    public void whenPrinted_thenFormatIsCorrect() {
        when(board.getSquare(0)).thenReturn(PLAYER_1);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(PLAYER_2);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(PLAYER_1);

        printer.print(board);

        assertEquals("""
                Current:                 Reference:
                +-----+-----+-----+  <<  +-----+-----+-----+
                |  X  |     |     |  <<  |  1  |  2  |  3  |
                +-----+-----+-----+  <<  +-----+-----+-----+
                |     |  O  |     |  <<  |  4  |  5  |  6  |
                +-----+-----+-----+  <<  +-----+-----+-----+
                |     |     |  X  |  <<  |  7  |  8  |  9  |
                +-----+-----+-----+  <<  +-----+-----+-----+
                """, out.toString());
    }
}
