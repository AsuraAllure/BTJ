package edu.project1.Representers;

import edu.project1.Representers.Readers.Reader;
import edu.project1.Representers.Writers.Writer;
import edu.project1.Representers.Readers.ConsoleReader;
import edu.project1.Representers.Writers.ConsoleWriter;

public class StandartRepresenter implements Representer {
    private final Writer out;
    private final Reader in;
    public StandartRepresenter(Writer out, Reader s) {
        this.out = out;
        this.in = s;
    }

    public StandartRepresenter() {
        this.out = new ConsoleWriter();
        this.in = new ConsoleReader();
    }

    @Override
    public void print(String s) {
        out.print(s);
    }

    @Override
    public void hitMessage() {
        out.print("Hit!");
    }

    @Override
    public void missMessage(int countMiss, int maxCount) {
        out.print("Missed, mistake " + countMiss
            + " out of " + maxCount + ".");
    }

    @Override
    public void guessMessage() {
        out.print("Guess a letter:");
    }

    @Override
    public void loseMessage() {
        out.print("You lost!");
    }

    @Override
    public void winMessage() {
        out.print("You won!");
    }

    @Override
    public void printReprWord(String s) {
        out.print("The word: " + s);
    }

    @Override
    public String input() {
        return in.read();
    }
}
