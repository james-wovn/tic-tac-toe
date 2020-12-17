package com.jamesball.learn.tictactoe;

class TicTacToeApplication {

    private static final Board board = new Board();

    public static void main(String[] args) {
        System.out.println(board.toString());
    }
}