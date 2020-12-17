package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTest {

    private static final int SIZE = 3;

    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void whenBoardIsInitialised_thenItIsHasTheCorrectDimensions() {
        assertNotNull(board.getBoard());

        String[] marks = getListOfMarks();

        assertEquals(SIZE * SIZE, marks.length);

        assertArrayEquals(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}, marks);
    }

    @Test
    public void whenBoardIsInitialised_thenAllSquaresAreUnmarked() {
        String[] marks = getListOfMarks();

        assertArrayEquals(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "}, marks);
    }

    @Test
    public void whenBoardIsPrinted_thenTheFormatShouldBeCorrect() {
        assertEquals("""
                    0   1   2
                  +---+---+---+
                0 |   |   |   |
                  +---+---+---+
                1 |   |   |   |
                  +---+---+---+
                2 |   |   |   |
                  +---+---+---+
                """, board.toString());
    }

    private String[] getListOfMarks() {
        String[] marks = {};

        for (Square[] squares : board.getBoard()) {
            for (Square square : squares) {
                String[] newMarks = Arrays.copyOf(marks, marks.length + 1);
                newMarks[newMarks.length - 1] = square.getMark();
                marks = newMarks;
            }
        }

        return marks;
    }
}
