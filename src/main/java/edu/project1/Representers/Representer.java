package edu.project1.Representers;

public interface Representer extends AutoCloseable {
    public void print(String s);
    public void hitMessage();
    public void missMessage(int countMiss, int maxCountMiss);
    public void guessMessage();
    public void loseMessage();
    public void winMessage();
    public void printReprWord(String s);
    public String input();
}
