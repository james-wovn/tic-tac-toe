package com.jamesball.learn.tictactoe;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class AskerTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    public void whenAskToSelectSquare_thenReturnInput(int square) {
        System.setIn(new ByteArrayInputStream("%d".formatted(square).getBytes()));

        Asker asker = new Asker(System.in, System.out);

        assertEquals("%d".formatted(square), asker.ask(anyString()));
    }
}
