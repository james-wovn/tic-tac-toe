package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class Game {

    private final Board board;
    private final BoardEvaluator evaluator;
    private final Mover mover;
    private final PlayerSwitcher switcher;

    private GameState state = IN_PROGRESS;

    public Game(Board board, BoardEvaluator evaluator, Mover mover, PlayerSwitcher switcher) {
        this.board = board;
        this.evaluator = evaluator;
        this.mover = mover;
        this.switcher = switcher;
    }

    public void takeTurn() {
        switcher.switchPlayer();

        PlayerMark currentPlayer = switcher.getCurrentPlayer();

        System.out.printf("%c Turn\n", currentPlayer.getMark());

        mover.move(board, switcher.getCurrentPlayer());
    }

    public boolean isGameOver() {
        state = evaluator.evaluate(board);

        return state == WON || state == DRAWN;
    }

    public void gameOver() {
        switch (state) {
            case WON -> System.out.printf("%c Winner!", switcher.getCurrentPlayer().getMark());
            case DRAWN -> System.out.printf("%c%c Draw!", PLAYER_1.getMark(), PLAYER_2.getMark());
        }
    }
}
