package com.jamesball.learn.tictactoe;

public class Mover {

    private final Board board;
    private final MoveAsker asker;
    private final MoveParser parser;

    public Mover(Board board, MoveAsker asker, MoveParser parser) {
        this.board = board;
        this.asker = asker;
        this.parser = parser;
    }

    public void move(PlayerMark mark) {
        String input = asker.ask("Enter square (1-9): ");

        while (true) {
            if (parser.validate(input)) {
                Move move = parser.parse(input, mark);

                board.markSquare(move);

                break;
            }
            input = asker.ask("Invalid square, try again: ");
        }
    }
}
