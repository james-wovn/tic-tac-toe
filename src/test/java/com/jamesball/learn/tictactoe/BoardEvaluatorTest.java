package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.jamesball.learn.tictactoe.BoardState.*;
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
    public void whenTopRowIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(PLAYER_1);
        when(board.getMark(1)).thenReturn(PLAYER_1);
        when(board.getMark(2)).thenReturn(PLAYER_1);
        when(board.getMark(3)).thenReturn(UNMARKED);
        when(board.getMark(4)).thenReturn(UNMARKED);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(UNMARKED);
        when(board.getMark(7)).thenReturn(UNMARKED);
        when(board.getMark(8)).thenReturn(UNMARKED);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenMiddleRowIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(UNMARKED);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(UNMARKED);
        when(board.getMark(3)).thenReturn(PLAYER_1);
        when(board.getMark(4)).thenReturn(PLAYER_1);
        when(board.getMark(5)).thenReturn(PLAYER_1);
        when(board.getMark(6)).thenReturn(UNMARKED);
        when(board.getMark(7)).thenReturn(UNMARKED);
        when(board.getMark(8)).thenReturn(UNMARKED);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenBottomRowIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(UNMARKED);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(UNMARKED);
        when(board.getMark(3)).thenReturn(UNMARKED);
        when(board.getMark(4)).thenReturn(UNMARKED);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(PLAYER_1);
        when(board.getMark(7)).thenReturn(PLAYER_1);
        when(board.getMark(8)).thenReturn(PLAYER_1);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenLeftColumnIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(PLAYER_1);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(UNMARKED);
        when(board.getMark(3)).thenReturn(PLAYER_1);
        when(board.getMark(4)).thenReturn(UNMARKED);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(PLAYER_1);
        when(board.getMark(7)).thenReturn(UNMARKED);
        when(board.getMark(8)).thenReturn(UNMARKED);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenMiddleColumnIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(UNMARKED);
        when(board.getMark(1)).thenReturn(PLAYER_1);
        when(board.getMark(2)).thenReturn(UNMARKED);
        when(board.getMark(3)).thenReturn(UNMARKED);
        when(board.getMark(4)).thenReturn(PLAYER_1);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(UNMARKED);
        when(board.getMark(7)).thenReturn(PLAYER_1);
        when(board.getMark(8)).thenReturn(UNMARKED);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenRightColumnIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(UNMARKED);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(PLAYER_1);
        when(board.getMark(3)).thenReturn(UNMARKED);
        when(board.getMark(4)).thenReturn(UNMARKED);
        when(board.getMark(5)).thenReturn(PLAYER_1);
        when(board.getMark(6)).thenReturn(UNMARKED);
        when(board.getMark(7)).thenReturn(UNMARKED);
        when(board.getMark(8)).thenReturn(PLAYER_1);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenTopLeftDiagonalIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(PLAYER_1);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(UNMARKED);
        when(board.getMark(3)).thenReturn(UNMARKED);
        when(board.getMark(4)).thenReturn(PLAYER_1);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(UNMARKED);
        when(board.getMark(7)).thenReturn(UNMARKED);
        when(board.getMark(8)).thenReturn(PLAYER_1);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenBottomLeftDiagonalIsComplete_thenIsWin() {
        when(board.getMark(0)).thenReturn(UNMARKED);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(PLAYER_1);
        when(board.getMark(3)).thenReturn(UNMARKED);
        when(board.getMark(4)).thenReturn(PLAYER_1);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(PLAYER_1);
        when(board.getMark(7)).thenReturn(UNMARKED);
        when(board.getMark(8)).thenReturn(UNMARKED);

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenNoCombinationIsComplete_thenIsInProgress() {
        when(board.getMark(0)).thenReturn(PLAYER_1);
        when(board.getMark(1)).thenReturn(UNMARKED);
        when(board.getMark(2)).thenReturn(PLAYER_1);
        when(board.getMark(3)).thenReturn(PLAYER_1);
        when(board.getMark(4)).thenReturn(PLAYER_1);
        when(board.getMark(5)).thenReturn(UNMARKED);
        when(board.getMark(6)).thenReturn(UNMARKED);
        when(board.getMark(7)).thenReturn(PLAYER_1);
        when(board.getMark(8)).thenReturn(UNMARKED);

        assertEquals(IN_PROGRESS, evaluator.evaluate(board));
    }

    @Test
    public void whenNoUnmarkedSquareAndNoCombinationIsComplete_thenIsDraw() {
        when(board.getMark(0)).thenReturn(PLAYER_1);
        when(board.getMark(1)).thenReturn(PLAYER_2);
        when(board.getMark(2)).thenReturn(PLAYER_1);
        when(board.getMark(3)).thenReturn(PLAYER_1);
        when(board.getMark(4)).thenReturn(PLAYER_1);
        when(board.getMark(5)).thenReturn(PLAYER_2);
        when(board.getMark(6)).thenReturn(PLAYER_2);
        when(board.getMark(7)).thenReturn(PLAYER_1);
        when(board.getMark(8)).thenReturn(PLAYER_2);

        assertEquals(DRAW, evaluator.evaluate(board));
    }
}
