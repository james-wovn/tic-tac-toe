package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoverTest {

    private static final char MARKED_SQUARE = 'X';

    private Mover mover;
    private MoveAsker asker;
    private MoveParser parser;
    private Board board;

    @BeforeEach
    public void setup() {
        asker = mock(MoveAsker.class);
        parser = mock(MoveParser.class);
        board = mock(Board.class);

        mover = new Mover(asker, parser);
    }

    @Test
    public void whenInputIsValid_thenSetMark() {
        when(asker.ask("Enter square (1-9): ")).thenReturn("1");

        when(parser.parse("1")).thenReturn(0);

        mover.move(board, MARKED_SQUARE);

        verify(asker).ask("Enter square (1-9): ");
        verify(parser).parse("1");
        verify(board).setMark(0, MARKED_SQUARE);
    }

    @Test
    public void whenInputIsNotValid_thenAskAgain() {
        when(asker.ask("Enter square (1-9): ")).thenReturn("10");
        when(asker.ask("Invalid square, try again: ")).thenReturn("1");

        when(parser.parse("10")).thenThrow(InvalidInputException.class);
        when(parser.parse("1")).thenReturn(0);

        mover.move(board, MARKED_SQUARE);

        verify(asker).ask("Enter square (1-9): ");
        verify(parser).parse("10");
        verify(asker).ask("Invalid square, try again: ");
        verify(parser).parse("1");
        verify(board).setMark(0, MARKED_SQUARE);
    }
}
