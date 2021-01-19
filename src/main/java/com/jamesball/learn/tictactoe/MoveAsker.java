package com.jamesball.learn.tictactoe;

import java.util.Scanner;

public class MoveAsker {

    private final Scanner scanner = new Scanner(System.in);

    public String ask(String message) {
        System.out.println(message);

        return scanner.nextLine();
    }
}
