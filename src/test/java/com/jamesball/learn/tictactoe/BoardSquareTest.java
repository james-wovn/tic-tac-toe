package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

public class BoardSquareTest {

    private BoardSquare square;

    @BeforeEach
    public void setup() {
        square = new BoardSquare(anyString());
    }

    @Test
    public void whenInitialised_thenMarkIsEmpty() {
        assertNull(square.getMark());
    }

    @Test
    public void whenMarkIsEmpty_thenSetMark() {
        square.setMark(anyString());

        assertEquals(anyString(), square.getMark());
    }

    @Test
    public void whenMarkIsEmpty_thenThrowMarkIsNotEmptyException() {
        square.setMark(anyString());

        assertThrows(MarkIsNotEmptyException.class, () -> square.setMark(anyString()));
    }
}
