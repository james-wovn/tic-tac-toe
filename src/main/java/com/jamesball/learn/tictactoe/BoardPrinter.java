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
                parseMark(board[0]), parseMark(board[1]), parseMark(board[2]),
                parseMark(board[3]), parseMark(board[4]), parseMark(board[5]),
                parseMark(board[6]), parseMark(board[7]), parseMark(board[8])
        );
    }

    private char parseMark(PlayerMark mark) {
        return switch (mark) {
            case UNMARKED -> ' ';
            case PLAYER_1 -> 'X';
            case PLAYER_2 -> 'O';
        };
    }
}
