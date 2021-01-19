package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.jamesball.learn.tictactoe.PlayerMark.O;
import static com.jamesball.learn.tictactoe.PlayerMark.X;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MessagePrinterTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private MessagePrinter printer;

    @Mock
    Board board;

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(out));

        printer = new MessagePrinter();
    }

    @ParameterizedTest(name = "{index} => mark = ''{0}''")
    @EnumSource(PlayerMark.class)
    public void whenPrintTurn_thenCorrectMessageIsPrintedInCorrectFormat(PlayerMark mark) {
        printer.printTurn(mark);

        assertEquals("\n%s Turn.\n".formatted(mark), out.toString());
    }
    
    @Test
    public void whenPrintBoard_thenCorrectMessageIsPrintedInCorrectFormat() {
        final Set<Integer> xMarkedSquares = new HashSet<>(Arrays.asList(0, 8));
        final Set<Integer> oMarkedSquares = new HashSet<>(Arrays.asList(2, 6));

        when(board.getMark(anyInt())).thenAnswer(invocation -> {
           Integer argument = invocation.getArgument(0);

           if (xMarkedSquares.contains(argument)) {
               return X;
           }
           else if (oMarkedSquares.contains(argument)) {
               return O;
           }

           return null;
        });

        printer.printBoard(board);

        assertEquals("""
                +-----+-----+-----+
                |  X  |     |  O  |
                +-----+-----+-----+
                |     |     |     |
                +-----+-----+-----+
                |  O  |     |  X  |
                +-----+-----+-----+
                """, out.toString());
    }

    @ParameterizedTest(name = "{index} => mark = ''{0}''")
    @EnumSource(PlayerMark.class)
    public void whenPrintWin_thenCorrectMessageIsPrintedInCorrectFormat(PlayerMark mark) {
        printer.printWin(mark);

        assertEquals("\n%s Winner!\n".formatted(mark), out.toString());
    }

    @Test
    public void whenPrintDraw_thenCorrectMessageIsPrintedInCorrectFormat() {
        printer.printDraw();

        assertEquals("\nXO Draw!\n", out.toString());
    }
}
