package com.jamesball.learn.tictactoe;

public class MoveChooser {

    private Board board;

    private MoveAsker asker = new MoveAsker();
    private MoveParser parser = new MoveParser();

    public MoveChooser(Board board) {
        this.board = board;
    }

    public Move choose(PlayerMark mark) {
        String input = asker.ask("Enter move (1-9): ");;

        while (true) {
            if (parser.isParsable(input)) {
                int square = parser.parse(input);

                if (!board.isMarked(square)) {
                    return new Move(mark, square);
                }
            }

            asker.ask("Invalid move, try again: ");
        }
    }
}
