package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MoveParserTest {

    private MoveParser parser;

    @BeforeEach
    public void beforeEach() {
        parser = new MoveParser();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void whenInputIsParsable_thenReturnTrue(String input) {
        assertTrue(parser.isParsable(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " 1 ", "0", "10", "a", "1a"})
    public void whenInputIsNotParsable_thenReturnFalse(String input) {
        assertFalse(parser.isParsable(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void whenInputIsParsable_thenReturnSquare(String input) {
        int square = parser.parse(input);

        assertEquals(Integer.parseInt(input) - 1, square);
    }
}
