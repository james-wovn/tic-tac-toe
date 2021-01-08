package com.jamesball.learn.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;

class TicTacToeApplication {

    private static final InputStream in = System.in;
    private static final PrintStream out = System.out;

    private static final Board board = new Board();
    private static final BoardEvaluator evaluator = new BoardEvaluator();
    private static final BoardPrinter printer = new BoardPrinter(out);

    private static final MoveAsker asker = new MoveAsker(in, out);
    private static final MoveParser parser = new MoveParser(board);
    private static final Mover mover = new Mover(board, asker, parser);

    private static final PlayerSwitcher switcher = new PlayerSwitcher();

    private static final Game game = new Game(board, evaluator, mover, switcher);

    public static void main(String[] args) {
        while (!game.isGameOver()) {
            printer.print(board);
            game.takeTurn();
        }

        printer.print(board);

        game.gameOver();
    }
}
