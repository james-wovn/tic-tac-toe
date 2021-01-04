package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void whenBoardIsSet_thenAllSquaresAreUnmarked(int square) {
        assertEquals(UNMARKED, board.getSquare(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsUnmarked_thenMarkSquare(int square) {
        board.markSquare(square, PLAYER_1);
        assertEquals(PLAYER_1, board.getSquare(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsMarked_thenThrowSquareIsMarkedException(int square) {
        board.markSquare(square, PLAYER_1);
        assertThrows(SquareIsMarkedException.class, () -> {
            board.markSquare(square, PLAYER_1);
            board.markSquare(square, PLAYER_1);
        });
    }

    @Test
    public void whenCopied_thenReturnNewBoardWithSameState() {
        Board boardCopy = board.copy();

        assertNotEquals(board, boardCopy);

        assertArrayEquals(board.getSquares(), boardCopy.getSquares());
    }
}
