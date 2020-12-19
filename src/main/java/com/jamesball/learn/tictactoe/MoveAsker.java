package com.jamesball.learn.tictactoe;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MoveAsker {

    private final Scanner scanner;
    private final PrintStream out;

    public MoveAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public String ask(String message) {
        out.println(message);
        return scanner.nextLine();
    }
}
