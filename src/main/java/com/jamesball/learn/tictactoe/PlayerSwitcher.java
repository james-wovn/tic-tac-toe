package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class PlayerSwitcher {

    private PlayerMark currentPlayer = PLAYER_1;

    public PlayerSwitcher() {
    }

    public PlayerMark getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        switch (currentPlayer) {
            case PLAYER_1 -> currentPlayer = PLAYER_2;
            case PLAYER_2 -> currentPlayer = PLAYER_1;
        }
    }
}
