package com.jamesball.learn.tictactoe;

public class MessagePrinter {

    private final static String BOARD_FORMAT =  """
                +-----+-----+-----+
                |  %s  |  %s  |  %s  |
                +-----+-----+-----+
                |  %s  |  %s  |  %s  |
                +-----+-----+-----+
                |  %s  |  %s  |  %s  |
                +-----+-----+-----+  
                """;

    public void printBoard() {
        System.out.printf(BOARD_FORMAT, "T", "i", "c", "T", "a", "c", "T", "o", "e");
    }

    public void printBoard(Board board) {
        System.out.printf(BOARD_FORMAT,
                parseMark(board.getMark(0)), parseMark(board.getMark(1)), parseMark(board.getMark(2)),
                parseMark(board.getMark(3)), parseMark(board.getMark(4)), parseMark(board.getMark(5)),
                parseMark(board.getMark(6)), parseMark(board.getMark(7)), parseMark(board.getMark(8))
        );
    }

    public void printTurn(PlayerMark mark) {
        System.out.printf("\n%s Turn.\n", mark);
    }

    public void printWin(PlayerMark mark) {
        System.out.printf("\n%s Winner!\n", mark);
    }

    public void printDraw() {
        System.out.print("\nXO Draw!\n");
    }

    private static String parseMark(PlayerMark mark) {
        if (mark == null) {
            return " ";
        }

        return mark.name();
    }
}
