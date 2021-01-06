package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {

    private Board board;
    private Move move;

    @BeforeEach
    public void beforeEach() {
        board = new Board();
        move = mock(Move.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenBoardIsSet_thenAllSquaresAreUnmarked(int square) {
        assertEquals(UNMARKED, board.getSquare(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsUnmarked_thenMarkSquare(int square) {
        when(move.getSquare()).thenReturn(square);
        when(move.getMark()).thenReturn(PLAYER_1);

        board.markSquare(move);
        assertEquals(PLAYER_1, board.getSquare(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsMarked_thenThrowSquareIsMarkedException(int square) {
        when(move.getSquare()).thenReturn(square);
        when(move.getMark()).thenReturn(PLAYER_1);

        assertThrows(SquareIsMarkedException.class, () -> {
            board.markSquare(move);
            board.markSquare(move);
        });
    }
}
