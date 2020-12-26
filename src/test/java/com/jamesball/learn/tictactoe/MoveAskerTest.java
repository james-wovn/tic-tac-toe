package com.jamesball.learn.tictactoe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class MoveAskerTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void whenAskToSelectSquare_thenReturnInput(int square) {
        System.setIn(new ByteArrayInputStream("%d".formatted(square).getBytes()));

        MoveAsker asker = new MoveAsker(System.in, System.out);

        assertEquals("%d".formatted(square), asker.ask(anyString()));
    }
}
