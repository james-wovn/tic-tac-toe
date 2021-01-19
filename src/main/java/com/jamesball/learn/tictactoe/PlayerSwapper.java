package com.jamesball.learn.tictactoe;

import java.util.Arrays;

public class PlayerSwapper {

    public PlayerMark swap(PlayerMark currentPlayer) {
        return Arrays.stream(PlayerMark.values())
                .filter(player -> player != currentPlayer)
                .findFirst()
                .orElseThrow();
    }
}
