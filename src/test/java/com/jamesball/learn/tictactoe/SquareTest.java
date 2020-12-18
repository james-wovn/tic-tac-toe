package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {

    private static final String PLAYER_1_MARK = "X";
    private static final String PLAYER_2_MARK = "O";

    private Square square;

    @BeforeEach
    public void setup() {
        square = new Square();
    }

    @Test
    public void whenUnmarked_thenSetMark() {
        square.setMark(PLAYER_1_MARK);

        assertEquals(PLAYER_1_MARK, square.getMark());
    }

    @Test
    public void whenMarked_thenThrowIsMarkedException() {
        square.setMark(PLAYER_1_MARK);

        assertThrows(IsMarkedException.class, () -> square.setMark(PLAYER_2_MARK));
    }
}
