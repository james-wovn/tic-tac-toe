package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.mockito.Mockito.*;

public class MoverTest {

    private Board board;
    private Move move;
    private Mover mover;
    private MoveAsker asker;
    private MoveParser parser;

    @BeforeEach
    public void beforeEach() {
        board = mock(Board.class);
        move = mock(Move.class);
        asker = mock(MoveAsker.class);
        parser = mock(MoveParser.class);

        mover = new Mover(board, asker, parser);
    }

    @Test
    public void whenInputIsValid_thenSetMark() {
        final String input = "1";
        final PlayerMark mark = PLAYER_1;

        when(asker.ask("Enter square (1-9): ")).thenReturn(input);
        when(parser.validate(input)).thenReturn(true);
        when(parser.parse(input, mark)).thenReturn(move);

        mover.move(mark);

        verify(asker).ask("Enter square (1-9): ");
        verify(board).markSquare(move);
    }

    @Test
    public void whenInputIsNotValid_thenAskAgain() {
        final String input = "1";
        final PlayerMark mark = PLAYER_1;

        when(asker.ask("Enter square (1-9): ")).thenReturn(input);
        when(asker.ask("Invalid square, try again: ")).thenReturn(input);
        when(parser.validate(anyString())).thenReturn(false).thenReturn(true);
        when(parser.parse(input, mark)).thenReturn(move);

        mover.move(mark);

        verify(asker).ask("Enter square (1-9): ");
        verify(asker).ask("Invalid square, try again: ");
        verify(board).markSquare(move);
    }
}
