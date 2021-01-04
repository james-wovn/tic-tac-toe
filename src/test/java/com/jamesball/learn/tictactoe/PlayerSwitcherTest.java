package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.jamesball.learn.tictactoe.PlayerMark.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerSwitcherTest {

    private static PlayerSwitcher switcher;

    @BeforeAll
    public static void beforeAll() {
        switcher = new PlayerSwitcher();
    }

    @BeforeEach
    public void beforeEach() {
        switcher.switchPlayer();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void whenPlayerSwitched_thenReturnCorrectPlayer(int turn) {
        if (turn % 2 == 1) {
            assertEquals(PLAYER_1, switcher.getCurrentPlayer());
        }
        else if (turn % 2 == 0) {
            assertEquals(PLAYER_2, switcher.getCurrentPlayer());
        }
    }
}
