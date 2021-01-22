package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void beforeEach() {
        board = new Board();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenIsMarked_thenReturnTrue(int square) {
        Move move = new Move(X, square);

        board.addMove(move);

        assertTrue(board.isMarked(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenIsNotMarked_thenReturnFalse(int square) {
        assertFalse(board.isMarked(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenMark_thenSquareIsMarked(int square) {
        Move move = new Move(X, square);

        board.addMove(move);

        assertEquals(X, board.getMark(square));
    }
}
