package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MoveParserTest {

    private Board board;
    private MoveParser parser;

    @BeforeEach
    public void beforeEach() {
        board = mock(Board.class);
        parser = new MoveParser(board);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void whenInputIsValid_thenReturnTrue(String input) {
        when(board.isUnmarked(anyInt())).thenReturn(true);

        assertTrue(parser.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " 1 ", "0", "10", "a", "1a"})
    public void whenInputInvalid_thenReturnFalse(String input) {
        when(board.isUnmarked(anyInt())).thenReturn(false);

        assertFalse(parser.validate(input));
    }
}
