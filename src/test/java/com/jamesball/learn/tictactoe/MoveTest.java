package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest {

    private Move move;

    @BeforeEach
    public void setup() {
        move = new Move();
    }

    @Test
    public void whenInputIsEmpty_thenThrowInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> move.parseInput(""));
    }

    @Test
    public void whenInputIsNotNumeric_thenThrowInvalidMoveException() {
        assertThrows(InvalidInputException.class, () -> move.parseInput("az"));
    }

    @Test
    public void whenInputIsTooShort_thenThrowInvalidMoveException() {
        assertThrows(InvalidInputException.class, () -> move.parseInput("1"));
    }

    @Test
    public void whenInputIsTooLong_thenThrowInvalidMoveException() {
        assertThrows(InvalidInputException.class, () -> move.parseInput("123"));
    }

    @Test
    public void whenInputIsValid_thenReturnValidPosition() {
        Position position = move.parseInput("00");

        assertEquals(Position.class, position.getClass());

        assertEquals(0, position.getRow());
        assertEquals(0, position.getColumn());
    }
}
