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

        board.setBoard();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenBoardIsSet_thenAllSquaresAreUnmarked(int square) {
        assertEquals(UNMARKED, board.getMark(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsUnmarked_thenMarkSquare(int square) {
        board.setMark(square, PLAYER_1);
        assertEquals(PLAYER_1, board.getMark(square));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenSquareIsMarked_thenThrowSquareIsMarkedException(int square) {
        board.setMark(square, PLAYER_1);
        assertThrows(SquareIsMarkedException.class, () -> {
            board.setMark(square, PLAYER_1);
            board.setMark(square, PLAYER_1);
        });
    }
}
