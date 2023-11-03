package edu.project1.Representers;

import java.io.PrintStream;
import java.util.Scanner;

public class StandartRepresenter implements Representer {
    private final PrintStream out = System.out;
    private final Scanner in = new Scanner(System.in);

    @Override
    public void print(String s) {
        out.println(s);
    }

    @Override
    public void hitMessage() {
        out.println("Hit!");
    }

    @Override
    public void missMessage(int countMiss, int maxCount) {
        out.println("Missed, mistake " + countMiss +
            " out of " + maxCount + ".");
    }

    @Override
    public void guessMessage() {
        out.println("Guess a letter:");
    }

    @Override
    public void loseMessage() {
        out.println("You lost!");
    }

    @Override
    public void winMessage() {
        out.println("You won!");
    }

    @Override
    public void printReprWord(String s) {
        out.println("The word: " + s);
    }

    @Override
    public String input() {
        return in.next();
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}
