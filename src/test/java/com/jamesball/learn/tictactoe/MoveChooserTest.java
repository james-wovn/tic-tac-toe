package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MoveChooserTest {

    private final static PlayerMark MARK = X;
    private final static String INPUT = "1";
    private final static int SQUARE = 0;

    private AutoCloseable closeable;

    @Mock
    private Board board;

    @Mock
    private MoveAsker asker;

    @Mock
    private MoveParser parser;

    @InjectMocks
    private MoveChooser chooser;

    @BeforeEach
    public void beforeEach() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void afterEach() throws Exception {
        closeable.close();
    }

    @Test
    public void whenChoiceIsParsableAndIsNotMarked_thenDoNotChooseAgain() {
        when(asker.ask("Enter move (1-9): ")).thenReturn(INPUT);
        when(parser.isParsable(INPUT)).thenReturn(true);
        when(parser.parse(INPUT)).thenReturn(SQUARE);
        when(board.isMarked(SQUARE)).thenReturn(false);

        Move move = chooser.choose(MARK);

        verify(asker).ask("Enter move (1-9): ");
        verify(parser).isParsable(INPUT);
        verify(parser).parse(INPUT);
        verify(board).isMarked(SQUARE);

        assertEquals(MARK, move.getMark());
        assertEquals(SQUARE, move.getSquare());
    }

    @Test
    public void whenChoiceIsNotParsable_thenChooseAgain() {
        when(asker.ask("Enter move (1-9): ")).thenReturn(INPUT);
        when(parser.isParsable(INPUT)).thenReturn(false, true);
        when(parser.parse(INPUT)).thenReturn(SQUARE);
        when(board.isMarked(SQUARE)).thenReturn(false);

        Move move = chooser.choose(MARK);

        verify(asker).ask("Enter move (1-9): ");
        verify(parser, times(2)).isParsable(INPUT);
        verify(parser).parse(INPUT);
        verify(board).isMarked(SQUARE);

        assertEquals(MARK, move.getMark());
        assertEquals(SQUARE, move.getSquare());
    }

    @Test
    public void whenChoiceIsParsableAndIsNotMarked_thenChooseAgain() {
        when(asker.ask("Enter move (1-9): ")).thenReturn(INPUT);
        when(parser.isParsable(INPUT)).thenReturn(true);
        when(parser.parse(INPUT)).thenReturn(SQUARE);
        when(board.isMarked(SQUARE)).thenReturn(true, false);

        Move move = chooser.choose(MARK);

        verify(asker).ask("Enter move (1-9): ");
        verify(parser, times(2)).isParsable(INPUT);
        verify(parser, times(2)).parse(INPUT);
        verify(board, times(2)).isMarked(SQUARE);

        assertEquals(MARK, move.getMark());
        assertEquals(SQUARE, move.getSquare());
    }
}
