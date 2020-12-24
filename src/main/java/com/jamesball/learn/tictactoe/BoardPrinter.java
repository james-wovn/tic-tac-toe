package com.jamesball.learn.tictactoe;

import java.io.PrintStream;

public class BoardPrinter {

    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void print(char[] board) {
        out.printf("""
                -----+-----+-----
                | %c  |  %c  |  %c |
                -----+-----+-----
                | %c  |  %c  |  %c |
                -----+-----+-----
                | %c  |  %c  |  %c |
                -----+-----+-----  
                """,
                board[0], board[1], board[2],
                board[3], board[4], board[5],
                board[6], board[7], board[8]
        );
    }
}
