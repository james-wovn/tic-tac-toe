package com.jamesball.learn.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveParserTest {

    private final String requiredInputPattern = "^[abc][123]$";

    private MoveParser parser;

    @BeforeEach
    public void setup() {
        parser = new MoveParser(Pattern.compile(requiredInputPattern, Pattern.CASE_INSENSITIVE));
    }

    @Test
    public void whenInputIsLowerCaseAndValid_thenReturnInput() {
        String[] rows = new String[]{"a", "b", "c"};
        String[] columns = new String[]{"1", "2", "3"};

        for (String row : rows) {
            for (String column : columns) {
                String input = "%s%s".formatted(row, column);
                assertEquals(input, parser.parse(input));
            }
        }
    }

    @Test
    public void whenInputIsUpperCaseAndValid_thenReturnInput() {
        String[] rows = new String[]{"A", "B", "C"};
        String[] columns = new String[]{"1", "2", "3"};

        for (String row : rows) {
            for (String column : columns) {
                String input = "%s%s".formatted(row, column);
                assertEquals(input, parser.parse(input));
            }
        }
    }

    @Test
    public void whenInputIsInvalid_thenThrowInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> parser.parse("")); // empty
        assertThrows(InvalidInputException.class, () -> parser.parse("a")); // too few characters
        assertThrows(InvalidInputException.class, () -> parser.parse("a1b")); // too many characters
        assertThrows(InvalidInputException.class, () -> parser.parse("z1")); // invalid row
        assertThrows(InvalidInputException.class, () -> parser.parse("a9")); // invalid column
        assertThrows(InvalidInputException.class, () -> parser.parse("1a")); // row and column reversed
        assertThrows(InvalidInputException.class, () -> parser.parse("!?")); // special characters
    }
}
