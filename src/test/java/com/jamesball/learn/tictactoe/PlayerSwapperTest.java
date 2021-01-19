package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerSwapperTest {

    private PlayerSwapper swapper;

    @BeforeEach
    public void beforeEach() {
        swapper = new PlayerSwapper();
    }

    @ParameterizedTest(name = "{index} => player = ''{0}''")
    @EnumSource(PlayerMark.class)
    public void whenSwap_thenReturnOtherPlayer(PlayerMark player) {
        PlayerMark otherPlayer = switch (player) {
            case X -> O;
            case O -> X;
        };

        assertEquals(otherPlayer, swapper.swap(player));
    }
}
