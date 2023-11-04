package edu.project1.Representers.Writers;

public class ConsoleWriter implements Writer {
    @Override
    public void print(String outputString) {
        System.out.println(outputString);
    }
}
