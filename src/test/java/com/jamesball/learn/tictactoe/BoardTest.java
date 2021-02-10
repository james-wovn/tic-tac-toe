package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        Move move = new Move(PlayerMark.X, square);

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
        Move move = new Move(PlayerMark.X, square);

        board.addMove(move);

        assertEquals(PlayerMark.X, board.getMark(square));
    }

    @Test
    public void whenRotated_thenRowsAreCorrectlyTransposedToColumns() {
        // Starting board position:
        // +-----+-----+-----+
        // |  X  |     |  O  |
        // +-----+-----+-----+
        // |  X  |  X  |  O  |
        // +-----+-----+-----+
        // |     |     |  O  |
        // +-----+-----+-----+
        //
        // Rotated board position:
        // +-----+-----+-----+
        // |     |  X  |  X  |
        // +-----+-----+-----+
        // |     |  X  |     |
        // +-----+-----+-----+
        // |  O  |  O  |  O  |
        // +-----+-----+-----+

        final Board startingBoardPosition = new Board(new PlayerMark[]{
                PlayerMark.X, null, PlayerMark.O,
                PlayerMark.X, PlayerMark.X, PlayerMark.O,
                null, null, PlayerMark.O
        });

        final Board rotatedBoardPosition = new Board(new PlayerMark[]{
                null, PlayerMark.X, PlayerMark.X,
                null, PlayerMark.X, null,
                PlayerMark.O, PlayerMark.O, PlayerMark.O
        });

        assertEquals(rotatedBoardPosition, startingBoardPosition.rotate());
    }

    @Test
    public void whenReflected_thenPositionsAreCorrectlyReversed() {
        // Starting board position:
        // +-----+-----+-----+
        // |  X  |     |  O  |
        // +-----+-----+-----+
        // |  X  |  X  |  O  |
        // +-----+-----+-----+
        // |     |     |  O  |
        // +-----+-----+-----+
        //
        // Reflected board position:
        // +-----+-----+-----+
        // |  O  |     |  X  |
        // +-----+-----+-----+
        // |  O  |  X  |  X  |
        // +-----+-----+-----+
        // |  O  |     |     |
        // +-----+-----+-----+

        final Board startingBoardPosition = new Board(new PlayerMark[]{
                PlayerMark.X, null, PlayerMark.O,
                PlayerMark.X, PlayerMark.X, PlayerMark.O,
                null, null, PlayerMark.O
        });

        final Board reflectedBoardPosition = new Board(new PlayerMark[]{
                PlayerMark.O, null, PlayerMark.X,
                PlayerMark.O, PlayerMark.X, PlayerMark.X,
                PlayerMark.O, null, null
        });

        assertEquals(reflectedBoardPosition, startingBoardPosition.reflect());
    }

    @Test
    public void whenBoardIsSymmetrical_thenEqualsIsTrue() {
        // Starting board position:
        // +-----+-----+-----+
        // |  X  |     |  O  |
        // +-----+-----+-----+
        // |  X  |  X  |  O  |
        // +-----+-----+-----+
        // |     |     |  O  |
        // +-----+-----+-----+
        //
        // Rotated board position:
        // +-----+-----+-----+
        // |     |  X  |  X  |
        // +-----+-----+-----+
        // |     |  X  |     |
        // +-----+-----+-----+
        // |  O  |  O  |  O  |
        // +-----+-----+-----+

        final Board startingBoardPosition = new Board(new PlayerMark[]{
                PlayerMark.X, null, PlayerMark.O,
                PlayerMark.X, PlayerMark.X, PlayerMark.O,
                null, null, PlayerMark.O
        });

        final Board rotatedBoardPosition = new Board(new PlayerMark[]{
                null, PlayerMark.X, PlayerMark.X,
                null, PlayerMark.X, null,
                PlayerMark.O, PlayerMark.O, PlayerMark.O
        });

        assertTrue(rotatedBoardPosition.isSymmetrical(startingBoardPosition));
    }
}
