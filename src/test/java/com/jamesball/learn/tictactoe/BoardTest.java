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

    @Test
    public void whenBoardIsSet_thenAllSquaresAreUnmarked() {
        final PlayerMark[] expectedSquares = new PlayerMark[]{
                UNMARKED, UNMARKED, UNMARKED,
                UNMARKED, UNMARKED, UNMARKED,
                UNMARKED, UNMARKED, UNMARKED
        };

        assertArrayEquals(expectedSquares, board.getSquares());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenPassedMove_thenMarkSquare(int square) {
        when(move.getSquare()).thenReturn(square);
        when(move.getMark()).thenReturn(PLAYER_1);

        board.markSquare(move);

        assertEquals(PLAYER_1, board.getSquare(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsMarked_thenItIsNotReturnedInUnmarkedSquares(int markedSquare) {
        int[] expectedUnmarkedSquares = new int[]{};

        for (int square = 0; square < board.getSquares().length; square++) {
            if (square != markedSquare) {
                int[] expectedUnmarkedSquaresCopy = new int[expectedUnmarkedSquares.length + 1];
                expectedUnmarkedSquaresCopy[expectedUnmarkedSquares.length] = square;
                expectedUnmarkedSquares = expectedUnmarkedSquaresCopy;
            }
        }

        when(move.getSquare()).thenReturn(markedSquare);
        when(move.getMark()).thenReturn(PLAYER_1);

        board.markSquare(move);

        assertArrayEquals(expectedUnmarkedSquares, board.unmarkedSquares());
    }
}
