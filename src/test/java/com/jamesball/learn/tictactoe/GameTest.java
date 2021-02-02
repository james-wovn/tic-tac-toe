package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    private AutoCloseable closeable;

    @Mock
    private MoveChooser chooser;

    @InjectMocks
    private Game game;

    @BeforeEach
    public void beforeEach() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void afterEach() throws Exception {
        closeable.close();
    }

    @Test
    public void whenXCompletesTheTopRowIn3Moves_thenXWinner() {
        // Terminal board position should be:
        // +-----+-----+-----+
        // |  X  |  X  |  X  |
        // +-----+-----+-----+
        // |     |     |     |
        // +-----+-----+-----+
        // |  O  |  O  |     |
        // +-----+-----+-----+

        when(chooser.choose(any(PlayerMark.class))).thenReturn(
                new Move(X, 0),
                new Move(O, 6),
                new Move(X, 1),
                new Move(O, 7),
                new Move(X, 2)
        );

        game.play();

        verify(chooser, times(3)).choose(X);
        verify(chooser, times(2)).choose(O);

        assertArrayEquals(new PlayerMark[]{X, X, X, null, null, null, O, O, null}, game.getBoard().getBoard());
        assertEquals(WIN, game.getState());
        assertEquals(X, game.getCurrentPlayer());
    }

    @Test
    public void whenOCompletesTheRightColumnIn3Moves_thenOWinner() {
        // Terminal board position should be:
        // +-----+-----+-----+
        // |  X  |     |  O  |
        // +-----+-----+-----+
        // |  X  |  X  |  O  |
        // +-----+-----+-----+
        // |     |     |  O  |
        // +-----+-----+-----+

        when(chooser.choose(any(PlayerMark.class))).thenReturn(
                new Move(X, 0),
                new Move(O, 2),
                new Move(X, 4),
                new Move(O, 8),
                new Move(X, 3),
                new Move(O, 5)
        );

        game.play();

        verify(chooser, times(3)).choose(X);
        verify(chooser, times(3)).choose(O);

        assertArrayEquals(new PlayerMark[]{X, null, O, X, X, O, null, null, O}, game.getBoard().getBoard());
        assertEquals(WIN, game.getState());
        assertEquals(O, game.getCurrentPlayer());
    }

    @Test
    public void whenAllSquaresMarkedAndNoCombinationIsComplete_thenXODraw() {
        // Terminal board position should be:
        // +-----+-----+-----+
        // |  X  |  X  |  O  |
        // +-----+-----+-----+
        // |  O  |  X  |  X  |
        // +-----+-----+-----+
        // |  X  |  O  |  O  |
        // +-----+-----+-----+

        when(chooser.choose(any(PlayerMark.class))).thenReturn(
                new Move(X, 0),
                new Move(O, 2),
                new Move(X, 1),
                new Move(O, 3),
                new Move(X, 4),
                new Move(O, 7),
                new Move(X, 5),
                new Move(O, 8),
                new Move(X, 6)
        );

        game.play();

        verify(chooser, times(5)).choose(X);
        verify(chooser, times(4)).choose(O);

        assertArrayEquals(new PlayerMark[]{X, X, O, O, X, X, X, O, O}, game.getBoard().getBoard());
        assertEquals(DRAW, game.getState());
        assertEquals(X, game.getCurrentPlayer());
    }
}
