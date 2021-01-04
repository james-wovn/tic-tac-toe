package com.jamesball.learn.tictactoe;

import static com.jamesball.learn.tictactoe.PlayerMark.*;

public class PlayerSwitcher {

    private PlayerMark currentPlayer;

    public PlayerSwitcher() {
    }

    public PlayerMark getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        if (currentPlayer == null) {
            currentPlayer = PLAYER_1;
        }
        else {
            switch (currentPlayer) {
                case PLAYER_1 -> currentPlayer = PLAYER_2;
                case PLAYER_2 -> currentPlayer = PLAYER_1;
            }
        }
    }
}
