package com.jamesball.learn.tictactoe;

public class PlayerSwitcher {

    private final char player1Mark;
    private final char player2Mark;

    private char currentPlayerMark;

    public PlayerSwitcher(char[] marks) {
        this.player1Mark = marks[0];
        this.player2Mark = marks[1];
        this.currentPlayerMark = marks[0];
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void switchPlayer() {
        if (currentPlayerMark == player1Mark) {
            currentPlayerMark = player2Mark;
        }
        else if (currentPlayerMark == player2Mark) {
            currentPlayerMark = player1Mark;
        }
    }
}
