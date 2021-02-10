package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {

    private final BoardEvaluator evaluator = new BoardEvaluator();
    private final PlayerSwapper swapper = new PlayerSwapper();

    private List<TerminalBoardPosition> terminalBoardPositions;

    private static class TerminalBoardPosition {

        private final Board boardPosition;
        private final PlayerMark playerMark;
        private final GameState gameState;

        public TerminalBoardPosition(Board boardPosition, PlayerMark playerMark, GameState gameState) {
            this.boardPosition = boardPosition;
            this.playerMark = playerMark;
            this.gameState = gameState;
        }

        public Board getBoardPosition() {
            return boardPosition;
        }

        public PlayerMark getPlayerMark() {
            return playerMark;
        }

        public GameState getGameState() {
            return gameState;
        }
    }

    @BeforeEach
    public void beforeEach() {
        terminalBoardPositions = findAllTerminalBoardPositions();
    }

    @Test
    public void whenAllPossibleMoveSequencesPlayed_then138DistinctTerminalBoardPositionsAreReached() {
        assertEquals(138, terminalBoardPositions.size());
    }

    @Test
    public void whenAllPossibleMoveSequencesPlayed_then91TerminalBoardPositionsAreWonByX() {
        assertEquals(91, terminalBoardPositions.stream()
                .filter(terminalBoardPosition -> terminalBoardPosition.getPlayerMark() == PlayerMark.X && terminalBoardPosition.getGameState() == GameState.WIN)
                .count()
        );
    }

    @Test
    public void whenAllPossibleMoveSequencesPlayed_then44TerminalBoardPositionsAreWonByO() {
        assertEquals(44, terminalBoardPositions.stream()
                .filter(terminalBoardPosition -> terminalBoardPosition.getPlayerMark() == PlayerMark.O && terminalBoardPosition.getGameState() == GameState.WIN)
                .count()
        );
    }

    @Test
    public void whenAllPossibleMoveSequencesPlayed_then3TerminalBoardPositionsAreDrawn() {
        assertEquals(3, terminalBoardPositions.stream()
                .filter(terminalBoardPosition -> terminalBoardPosition.getGameState() == GameState.DRAW)
                .count()
        );
    }

    private List<TerminalBoardPosition> findAllTerminalBoardPositions() {
        final List<TerminalBoardPosition> terminalBoardPositions = new ArrayList<>();

        Board startingBoardPosition = new Board();
        PlayerMark startingPlayerMark = PlayerMark.X;

        playAllPossibleMoveSequences(terminalBoardPositions, startingBoardPosition, startingPlayerMark);

        return terminalBoardPositions;
    }

    private void playAllPossibleMoveSequences(List<TerminalBoardPosition> terminalBoardPositions, Board currentBoardPosition, PlayerMark currentPlayerMark) {
        GameState currentGameState = evaluator.evaluate(currentBoardPosition);

        if (isTerminalBoardPositionReached(currentGameState)) {
            addTerminalBoardPosition(terminalBoardPositions, currentBoardPosition, currentPlayerMark, currentGameState);
        }
        else {
            for (Move move : availableMoves(currentBoardPosition, currentPlayerMark)) {
                final Board boardPosition = nextBoardPosition(currentBoardPosition, move);

                final PlayerMark playerMark = swapper.swap(currentPlayerMark);

                playAllPossibleMoveSequences(terminalBoardPositions, boardPosition, playerMark);
            }
        }
    }

    private boolean isTerminalBoardPositionReached(GameState state) {
        return state != GameState.IN_PLAY;
    }

    private void addTerminalBoardPosition(List<TerminalBoardPosition> terminalBoardPositions, Board boardPosition, PlayerMark playerMark, GameState gameState) {
        List<Board> boardPositions = terminalBoardPositions.stream()
                .map(TerminalBoardPosition::getBoardPosition)
                .collect(Collectors.toCollection(ArrayList::new));

        if (boardPositions.stream().anyMatch(board -> board.isSymmetrical(boardPosition))) {
            return;
        }

        TerminalBoardPosition terminalBoardPosition = new TerminalBoardPosition(boardPosition, swapper.swap(playerMark), gameState);

        terminalBoardPositions.add(terminalBoardPosition);
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