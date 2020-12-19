package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void whenCoordinateIsValid_thenReturnSquare() {
        String[] coordinates = new String[]{"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};

        for (String coordinate : coordinates) {
            assertEquals(BoardSquare.class, board.getSquare(coordinate).getClass());
        }
    }

    @Test
    public void whenCoordinateIsInvalid_thenThrowInvalidCoordinateException() {
        assertThrows(InvalidCoordinateException.class, () -> board.getSquare("z9"));
    }

    @Test
    public void whenGetMarks_thenReturnArrayOfStrings() {
        assertArrayEquals(new String[9], board.getMarks());
    }
}
