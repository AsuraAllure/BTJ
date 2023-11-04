package edu.project1;

import edu.project1.Dictionary.StandartDictionary;
import edu.project1.Managers.StandartManager;
import edu.project1.Representers.Readers.TestReader;
import edu.project1.Representers.StandartRepresenter;
import edu.project1.Representers.Writers.TestWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestHangman {

    @Test
    public void testHangman() {
        ArrayList<String> output = new ArrayList<>();
        List<String> input = List.of(new String[] {
            "p",
            "d",
            "i",
            "z",
            "a"
        });
        Hangman game = new Hangman(
            new StandartManager(),
            new StandartDictionary(),
            new StandartRepresenter(
                new TestWriter(output),
                new TestReader(input)
            )
        );
        List<String> expectedOutput = List.of(
            "It is Hangman game!",
            "Guess a letter:",
            "Hit!",
            "The word: p****",
            "Guess a letter:",
            "Missed, mistake 1 out of 5.",
            "The word: p****",
            "Guess a letter:",
            "Hit!",
            "The word: pi***",
            "Guess a letter:",
            "Hit!",
            "The word: pizz*",
            "Guess a letter:",
            "Hit!",
            "The word: pizza",
            "You won!"
        );
        game.start();
        Assertions.assertEquals(expectedOutput, output);
    }
}
