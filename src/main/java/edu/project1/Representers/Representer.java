package edu.project1.Representers;

public interface Representer {
    void print(String s);

    void hitMessage();

    void missMessage(int countMiss, int maxCountMiss);

    void guessMessage();

    void loseMessage();

    void winMessage();

    void printReprWord(String s);

    String input();
}
