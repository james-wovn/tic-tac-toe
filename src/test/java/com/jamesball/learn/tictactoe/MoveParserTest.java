package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveParserTest {

    private MoveParser parser;

    @BeforeEach
    public void beforeEach() {
        parser = new MoveParser("^[1-9]$");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void whenValidSquareIsInput_thenReturnSquareAsInt(String input) {
        int square = Integer.parseInt(input) - 1;
        assertEquals(square, parser.parse(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    public void whenValidSquareIsInputAndIncludesWhitespace_thenReturnInputAsInt(String input) {
        int square = Integer.parseInt(input) - 1;
        assertEquals(square, parser.parse(" " + input + " "));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "10", "a", "1a"})
    public void whenInvalidSquareIsInput_thenThrowInvalidInputException(String input) {
        assertThrows(InvalidInputException.class, () -> parser.parse(input));
    }
}
