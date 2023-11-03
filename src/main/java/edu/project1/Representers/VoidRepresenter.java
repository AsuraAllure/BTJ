package edu.project1.Representers;

public class VoidRepresenter implements Representer{
    @Override
    public void print(String s) {}

    @Override
    public void hitMessage() {}
    @Override
    public void missMessage(int countMiss, int maxCountMiss) {}

    @Override
    public void guessMessage() {}

    @Override
    public void loseMessage() {}
    @Override
    public void winMessage() {}
    @Override
    public void printReprWord(String s) {}
    @Override
    public String input() {
        return null;
    }
    @Override
    public void close() throws Exception {

    }
}
