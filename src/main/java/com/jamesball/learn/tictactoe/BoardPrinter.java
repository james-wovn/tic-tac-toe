package com.jamesball.learn.tictactoe;

import java.io.PrintStream;

public class BoardPrinter {

    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(Board board) {
        out.printf("""
                +-----+-----+-----+
                |  %c  |  %c  |  %c  |
                +-----+-----+-----+
                |  %c  |  %c  |  %c  |
                +-----+-----+-----+
                |  %c  |  %c  |  %c  |
                +-----+-----+-----+  
                """,
                board.getSquare(0).getMark(), board.getSquare(1).getMark(), board.getSquare(2).getMark(),
                board.getSquare(3).getMark(), board.getSquare(4).getMark(), board.getSquare(5).getMark(),
                board.getSquare(6).getMark(), board.getSquare(7).getMark(), board.getSquare(8).getMark()
        );
    }
}
