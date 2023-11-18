package edu.project1.Representers.Readers;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private final Scanner in = new Scanner(System.in);

    @Override
    public String read() {
        return in.next();
    }
}
