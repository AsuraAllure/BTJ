package edu.project1;

import edu.project1.GameEnum.GuessEnum;
import edu.project1.HangmanWords.StandartHangmanWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHangmanWords {

    @Test
    public void testGuess() {
        StandartHangmanWord c = new StandartHangmanWord("pizza");
        Assertions.assertEquals("*****", c.getRepresentWord());
        Assertions.assertEquals(GuessEnum.MISS, c.guess('l'));
        Assertions.assertEquals("*****", c.getRepresentWord());
        Assertions.assertEquals(GuessEnum.HIT, c.guess('z'));
        Assertions.assertEquals("**zz*", c.getRepresentWord());
        Assertions.assertEquals(GuessEnum.HIT, c.guess('p'));
        Assertions.assertEquals(GuessEnum.HIT, c.guess('i'));
        Assertions.assertFalse(c.isGuessed());
        Assertions.assertEquals(GuessEnum.HIT, c.guess('a'));
        Assertions.assertTrue(c.isGuessed());
        Assertions.assertEquals("pizza", c.getRepresentWord());
    }

    @Test
    public void testLength() {
        Assertions.assertEquals(5, new StandartHangmanWord("pizza").getLength());
        Assertions.assertEquals(0, new StandartHangmanWord("").getLength());
        Assertions.assertEquals(3, new StandartHangmanWord("sad").getLength());
    }
}
