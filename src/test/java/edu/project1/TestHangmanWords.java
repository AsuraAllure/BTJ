package edu.project1;

import edu.project1.GameEnum.GuessEnum;
import edu.project1.HangmanWords.StandartHangmanWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHangmanWords {

    @Test
    public void standartHangmanWord(){
        StandartHangmanWord c = new StandartHangmanWord("pizza");
        Assertions.assertEquals("*****", c.getRepresentWord());
        Assertions.assertEquals(GuessEnum.MISS ,c.guess('l'));
        Assertions.assertEquals("*****", c.getRepresentWord());
        Assertions.assertEquals(GuessEnum.HIT ,c.guess('z'));
        Assertions.assertEquals("**zz*", c.getRepresentWord());
        Assertions.assertEquals(GuessEnum.HIT ,c.guess('p'));
        Assertions.assertEquals(GuessEnum.HIT ,c.guess('i'));
        Assertions.assertEquals(GuessEnum.HIT ,c.guess('a'));
        Assertions.assertEquals("pizza", c.getRepresentWord());
    }
}
