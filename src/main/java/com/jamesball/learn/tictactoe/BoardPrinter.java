package com.jamesball.learn.tictactoe;

import java.io.PrintStream;

public class BoardPrinter {

    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(PlayerMark[] board) {
        out.printf("""
                +-----+-----+-----+
                |  %c  |  %c  |  %c  |
                +-----+-----+-----+
                |  %c  |  %c  |  %c  |
                +-----+-----+-----+
                |  %c  |  %c  |  %c  |
                +-----+-----+-----+  
                """,
                board[0].getMark(), board[1].getMark(), board[2].getMark(),
                board[3].getMark(), board[4].getMark(), board[5].getMark(),
                board[6].getMark(), board[7].getMark(), board[8].getMark()
        );
    }
}
