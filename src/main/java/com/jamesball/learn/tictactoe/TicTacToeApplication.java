package com.jamesball.learn.tictactoe;

class TicTacToeApplication {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        BoardPrinter printer = new BoardPrinter(System.out);

        printer.print("TicTacToe".split(""));
    }
}