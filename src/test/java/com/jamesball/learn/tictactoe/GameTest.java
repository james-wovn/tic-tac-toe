package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board board;
    private BoardEvaluator evaluator;
    private PlayerSwitcher switcher;

    @BeforeEach
    public void beforeEach() {
        board = mock(Board.class);
        evaluator = mock(BoardEvaluator.class);
        Mover mover = mock(Mover.class);
        switcher = mock(PlayerSwitcher.class);
        game = new Game(board, evaluator, mover, switcher);
    }

    @Test
    public void whenGameIsInProgress_thenIsNotGameOver() {
        when(switcher.getCurrentPlayer()).thenReturn(PLAYER_1);
        when(evaluator.evaluate(board)).thenReturn(IN_PROGRESS);

        game.takeTurn();

        assertFalse(game.isGameOver());
    }

    @Test
    public void whenGameIsDrawn_thenIsGameOver() {
        when(switcher.getCurrentPlayer()).thenReturn(PLAYER_1);
        when(evaluator.evaluate(board)).thenReturn(DRAWN);

        game.takeTurn();

        assertTrue(game.isGameOver());
    }

    @Test
    public void whenGameIsWon_thenIsGameOver() {
        when(switcher.getCurrentPlayer()).thenReturn(PLAYER_1);
        when(evaluator.evaluate(board)).thenReturn(WON);

        game.takeTurn();

        assertTrue(game.isGameOver());
    }

    @Test
    public void whenGameOverAndGameIsWon_thenShowWinner() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        when(evaluator.evaluate(board)).thenReturn(WON);
        when(switcher.getCurrentPlayer()).thenReturn(PLAYER_1);

        game.isGameOver();
        game.gameOver();

        assertEquals("X Winner!".formatted(PLAYER_1), out.toString());
    }

    @Test
    public void whenGameOverAndGameIsWon_thenShowDraw() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        when(evaluator.evaluate(board)).thenReturn(DRAWN);

        game.isGameOver();
        game.gameOver();

        assertEquals("XO Draw!", out.toString());
    }
}
