package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class PlayerSwitcher {

    private PlayerMark currentPlayer;

    public PlayerSwitcher() {
        this.currentPlayer = PLAYER_1;
    }

    public PlayerMark getCurrentPlayerMark() {
        return currentPlayer;
    }

    public void switchPlayer() {
        switch (currentPlayer) {
            case PLAYER_1 -> currentPlayer = PLAYER_2;
            case PLAYER_2 -> currentPlayer = PLAYER_1;
        }
    }
}
