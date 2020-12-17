package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private static Board board;

    private static final int BOARD_SIZE = 3;

    @BeforeAll
    public static void setup() {
        board = new Board();
    }

    @Test
    public void shouldHaveCorrectLayout() {
        assertArrayEquals(board.getBoard(), new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}});
    }

    @Test
    public void shouldHaveEmptyMarkAtAllBoardSpaces() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                assertEquals(" ", board.getMarkAtBoardSpace(row, column));
            }
        }
    }

    @Test
    public void shouldHaveCorrectAppearance() {
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
}
