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
        when(board.getBoard()).thenReturn(new PlayerMark[]{
                PLAYER_1, UNMARKED, UNMARKED,
                UNMARKED, PLAYER_2, UNMARKED,
                UNMARKED, UNMARKED, PLAYER_1
        });

        printer.print(board.getBoard());

        assertEquals("""
                +-----+-----+-----+
                |  X  |     |     |
                +-----+-----+-----+
                |     |  O  |     |
                +-----+-----+-----+
                |     |     |  X  |
                +-----+-----+-----+
                """, out.toString());
    }
}
