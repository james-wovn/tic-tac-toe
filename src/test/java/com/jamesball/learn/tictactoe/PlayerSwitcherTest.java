package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerSwitcherTest {

    private final static char[] MARKS = new char[]{'X', 'O'};
    private final static char PLAYER_1_MARK = 'X';
    private final static char PLAYER_2_MARK = 'O';

    private static PlayerSwitcher switcher;

    @BeforeAll
    public static void beforeAll() {
        switcher = new PlayerSwitcher(MARKS);
    }

    @AfterEach
    public void afterEach() {
        switcher.switchPlayer();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void whenPlayerSwitched_thenReturnCorrectPlayer(int turn) {
        if (turn % 2 == 1) {
            assertEquals(PLAYER_1_MARK, switcher.getCurrentPlayerMark());
        }
        else if (turn % 2 == 0) {
            assertEquals(PLAYER_2_MARK, switcher.getCurrentPlayerMark());
        }
    }
}
