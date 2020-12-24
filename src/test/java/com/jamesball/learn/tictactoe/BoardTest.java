package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private static final char UNMARKED_SQUARE = ' ';
    private static final char MARKED_SQUARE = 'X';

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();

        board.setBoard();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenBoardIsSet_thenAllSquaresAreUnmarked(int square) {
        assertEquals(UNMARKED_SQUARE, board.getMark(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsUnmarked_thenMarkSquare(int square) {
        board.setMark(square, MARKED_SQUARE);
        assertEquals(MARKED_SQUARE, board.getMark(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsMarked_thenThrowSquareIsMarkedException(int square) {
        board.setMark(square, MARKED_SQUARE);
        assertThrows(SquareIsMarkedException.class, () -> {
            board.setMark(square, MARKED_SQUARE);
            board.setMark(square, MARKED_SQUARE);
        });
    }
}
