package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class MoveAskerTest {

    @Test
    public void whenAsk_thenReturnInput() {
        System.setIn(new ByteArrayInputStream("0".getBytes()));

        MoveAsker asker = new MoveAsker(System.in, System.out);

        assertEquals("0", asker.ask(anyString()));
    }
}
