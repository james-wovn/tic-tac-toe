package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardEvaluatorTest {

    private Board board;
    private BoardEvaluator evaluator;

    @BeforeEach
    public void beforeEach() {
        board = mock(Board.class);
        evaluator = new BoardEvaluator();
    }

    @Test
    public void whenTopRowIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(PLAYER_1);
        when(board.getSquare(1)).thenReturn(PLAYER_1);
        when(board.getSquare(2)).thenReturn(PLAYER_1);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(UNMARKED);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenMiddleRowIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(UNMARKED);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(PLAYER_1);
        when(board.getSquare(4)).thenReturn(PLAYER_1);
        when(board.getSquare(5)).thenReturn(PLAYER_1);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenBottomRowIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(UNMARKED);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(UNMARKED);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(PLAYER_1);
        when(board.getSquare(7)).thenReturn(PLAYER_1);
        when(board.getSquare(8)).thenReturn(PLAYER_1);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenLeftColumnIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(PLAYER_1);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(PLAYER_1);
        when(board.getSquare(4)).thenReturn(UNMARKED);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(PLAYER_1);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenMiddleColumnIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(UNMARKED);
        when(board.getSquare(1)).thenReturn(PLAYER_1);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(PLAYER_1);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(PLAYER_1);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenRightColumnIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(UNMARKED);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(PLAYER_1);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(UNMARKED);
        when(board.getSquare(5)).thenReturn(PLAYER_1);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(PLAYER_1);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenTopLeftDiagonalIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(PLAYER_1);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(PLAYER_1);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(PLAYER_1);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenBottomLeftDiagonalIsComplete_thenGameIsWon() {
        when(board.getSquare(0)).thenReturn(UNMARKED);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(PLAYER_1);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(PLAYER_1);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(PLAYER_1);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(WON, evaluator.evaluate(board));
    }

    @Test
    public void whenAllSquaresAreUnmarked_thenGameIsInProgress() {
        when(board.getSquares()).thenReturn(new PlayerMark[9]);

        when(board.getSquare(0)).thenReturn(UNMARKED);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(UNMARKED);
        when(board.getSquare(3)).thenReturn(UNMARKED);
        when(board.getSquare(4)).thenReturn(UNMARKED);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(UNMARKED);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(IN_PROGRESS, evaluator.evaluate(board));
    }

    @Test
    public void whenNoCombinationIsComplete_thenGameIsInProgress() {
        when(board.getSquares()).thenReturn(new PlayerMark[9]);

        when(board.getSquare(0)).thenReturn(PLAYER_1);
        when(board.getSquare(1)).thenReturn(UNMARKED);
        when(board.getSquare(2)).thenReturn(PLAYER_1);
        when(board.getSquare(3)).thenReturn(PLAYER_1);
        when(board.getSquare(4)).thenReturn(PLAYER_1);
        when(board.getSquare(5)).thenReturn(UNMARKED);
        when(board.getSquare(6)).thenReturn(UNMARKED);
        when(board.getSquare(7)).thenReturn(PLAYER_1);
        when(board.getSquare(8)).thenReturn(UNMARKED);

        assertEquals(IN_PROGRESS, evaluator.evaluate(board));
    }

    @Test
    public void whenNoUnmarkedSquareAndNoCombinationIsComplete_thenGameIsDrawn() {
        when(board.getSquares()).thenReturn(new PlayerMark[9]);

        when(board.getSquare(0)).thenReturn(PLAYER_2);
        when(board.getSquare(1)).thenReturn(PLAYER_2);
        when(board.getSquare(2)).thenReturn(PLAYER_1);
        when(board.getSquare(3)).thenReturn(PLAYER_1);
        when(board.getSquare(4)).thenReturn(PLAYER_2);
        when(board.getSquare(5)).thenReturn(PLAYER_2);
        when(board.getSquare(6)).thenReturn(PLAYER_2);
        when(board.getSquare(7)).thenReturn(PLAYER_1);
        when(board.getSquare(8)).thenReturn(PLAYER_1);

        assertEquals(DRAWN, evaluator.evaluate(board));
    }
}
