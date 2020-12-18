package com.jamesball.learn.tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Move {

    private static final Pattern PATTERN = Pattern.compile("^[0-9]{2}$");

    private Scanner scanner = new Scanner(System.in);

    public Move() {
    }

    public String input() {
        System.out.println("Enter board square to mark: ");

        String input = scanner.nextLine();

        scanner.close();

        return input;
    }

    public Position parseInput(String input) throws InvalidInputException {
        Matcher matcher = PATTERN.matcher(input);

        if (matcher.find()) {
            char[] coordinates = input.toCharArray();

            int row = Character.getNumericValue(coordinates[0]);
            int column = Character.getNumericValue(coordinates[1]);

            return new Position(row, column);
        }
        else {
            throw new InvalidInputException();
        }
    }
}
