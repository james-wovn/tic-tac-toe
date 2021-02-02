package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {

    private final BoardEvaluator evaluator = new BoardEvaluator();
    private final PlayerSwapper swapper = new PlayerSwapper();

    @Test
    public void whenMoveSequencePlayed_thenCorrectTerminalBoardPositionReached() {
        final List<List<Move>> moveSequences = moveSequences();

        assertEquals(moveSequences().stream().distinct().count(), moveSequences.size());
    }

    private List<List<Move>> moveSequences() {
        final List<List<Move>> moveSequences = new ArrayList<>();

        Board startingBoardPosition = new Board();
        PlayerMark startingPlayerMark = PlayerMark.X;

        findAllMoveSequences(moveSequences, new ArrayList<>(), startingBoardPosition, startingPlayerMark);

        return moveSequences;
    }

    private void findAllMoveSequences(List<List<Move>> moveSequences, List<Move> currentMoveSequence, Board currentBoardPosition, PlayerMark currentPlayerMark) {
        if (isTerminalBoardPositionReached(currentBoardPosition)) {
            moveSequences.add(currentMoveSequence);
        }
        else {
            for (Move move : availableMoves(currentBoardPosition, currentPlayerMark)) {
                final List<Move> moveSequence = new ArrayList<>(currentMoveSequence);
                moveSequence.add(move);

                final Board boardPosition = nextBoardPosition(currentBoardPosition, move);

                final PlayerMark playerMark = swapper.swap(currentPlayerMark);

                findAllMoveSequences(moveSequences, moveSequence, boardPosition, playerMark);
            }
        }
    }

    private boolean isTerminalBoardPositionReached(Board boardPosition) {
        return !GameState.IN_PLAY.equals(evaluator.evaluate(boardPosition));
    }

    private Board nextBoardPosition(Board boardPosition, Move move) {
        Board boardPositionCopy = boardPosition.clone();

        boardPositionCopy.addMove(move);

        return boardPositionCopy;
    }

    private List<Move> availableMoves(Board boardPosition, PlayerMark playerMark) {
        return IntStream.range(0, boardPosition.getSize())
                .filter(square -> !boardPosition.isMarked(square))
                .mapToObj(square -> new Move(playerMark, square))
                .collect(Collectors.toList());
    }
}