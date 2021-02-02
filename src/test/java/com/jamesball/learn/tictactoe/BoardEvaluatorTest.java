package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BoardEvaluatorTest {

    private BoardEvaluator evaluator;
    
    private AutoCloseable closeable;
    
    @Mock
    private Board board;
    
    @BeforeEach
    public void beforeEach() {
        evaluator = new BoardEvaluator();
        closeable = MockitoAnnotations.openMocks(this);
    }
    
    @AfterEach
    public void afterEach() throws Exception {
        closeable.close();
    }

    @Test
    public void whenTopRowIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(0, 1, 2));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenMiddleRowIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(3, 4, 5));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenBottomRowIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(6, 7, 8));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenLeftColumnIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(0, 3, 6));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenMiddleColumnIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(1, 4, 7));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenRightColumnIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(2, 5, 8));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenDownwardDiagonalIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(0, 4, 8));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenUpwardDiagonalIsComplete_thenGameIsWon() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(2, 4, 6));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        assertEquals(WIN, evaluator.evaluate(board));
    }

    @Test
    public void whenAllSquaresAreMarkedAndNoCombinationIsComplete_thenGameIsDrawn() {
        final Set<Integer> xMarkedSquares = new HashSet<>(Arrays.asList(0, 1, 4, 5, 6));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (xMarkedSquares.contains(argument)) {
                return X;
            }

            return O;
        });

        when(board.getSize()).thenReturn(9);
        when(board.isMarked(anyInt())).thenReturn(true);

        assertEquals(DRAW, evaluator.evaluate(board));
    }

    @Test
    public void whenNoCombinationIsComplete_thenGameIsInPlay() {
        final Set<Integer> markedSquares = new HashSet<>(Arrays.asList(0, 2, 3, 4, 7));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            if (markedSquares.contains(argument)) {
                return X;
            }

            return null;
        });

        when(board.getSize()).thenReturn(9);
        when(board.isMarked(anyInt())).thenAnswer(invocation -> {
            Integer argument = invocation.getArgument(0);

            return markedSquares.contains(argument);
        });

        assertEquals(IN_PLAY, evaluator.evaluate(board));
    }
}
