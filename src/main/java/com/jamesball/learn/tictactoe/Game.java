package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.GameState.*;
import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class Game {

    private Board board = new Board();
    private BoardEvaluator evaluator = new BoardEvaluator(board);
    private MoveChooser chooser = new MoveChooser(board);
    private MessagePrinter printer = new MessagePrinter();
    private PlayerSwapper swapper = new PlayerSwapper();
    private GameState state = IN_PLAY;
    private PlayerMark currentPlayer = X;

    public Board getBoard() {
        return board;
    }

    public GameState getState() {
        return state;
    }

    public PlayerMark getCurrentPlayer() {
        return currentPlayer;
    }

    public void play() {
        while (true) {
            turn();

            if (isGameOver()) {
                gameOver();

                break;
            }

            next();
        }
    }

    private boolean isGameOver() {
        return state == WIN || state == DRAW;
    }

    private void turn() {
        printer.printBoard(board);
        printer.printTurn(currentPlayer);

        Move move = chooser.choose(currentPlayer);

        board.mark(move);

        state = evaluator.evaluate();
    }

    private void next() {
        currentPlayer = swapper.swap(currentPlayer);
    }

    private void gameOver() {
        printer.printBoard(board);

        switch (state) {
            case WIN -> printer.printWin(currentPlayer);
            case DRAW -> printer.printDraw();
        }
    }
}
