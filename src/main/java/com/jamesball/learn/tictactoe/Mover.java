package com.jamesball.learn.tictactoe;

public class Mover {

    private final MoveAsker asker;
    private final MoveParser parser;

    public Mover(MoveAsker asker, MoveParser parser) {
        this.asker = asker;
        this.parser = parser;
    }

    public void move(Board board, PlayerMark mark) {
        String input = asker.ask("Enter square (1-9): ");

        while (true) {
            try {
                int square =  parser.parse(input);

                Move move = new Move(square, mark);

                board.markSquare(move);

                break;
            } catch (InvalidInputException | SquareIsMarkedException exception) {
                input = asker.ask("Invalid square, try again: ");
            }
        }
    }
}
