package com.jamesball.learn.tictactoe;

class TicTacToeApplication {

    private static final Board board = new Board();

    public static void main(String[] args) {
        System.out.println(board.toString());
        board.getSquare(new Position(0, 0)).setMark("X");
        System.out.println(board.toString());
    }
}