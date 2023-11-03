package edu.project1;

import edu.project1.GameEnum.GameState;
import edu.project1.HangmanWords.HangmanWords;
import edu.project1.HangmanWords.StandartHangmanWord;
import edu.project1.Managers.StandartManager;
import edu.project1.Managers.TooLongWordException;
import edu.project1.Managers.TooSmallWordException;
import edu.project1.Representers.VoidRepresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestManager {
    @Test
    public void testGuessLetter() {
        StandartManager st = new StandartManager(5, new VoidRepresenter());
        st.setWord("pizza");
        Assertions.assertEquals(GameState.GAME, st.guessLetter('p'));
        Assertions.assertEquals(GameState.GAME, st.guessLetter('q'));
        Assertions.assertEquals(GameState.GAME, st.guessLetter('q'));
        Assertions.assertEquals(GameState.GAME, st.guessLetter('q'));
        Assertions.assertEquals(GameState.GAME, st.guessLetter('q'));
        Assertions.assertEquals(GameState.LOSE, st.guessLetter('q'));
        Assertions.assertEquals(GameState.LOSE, st.guessLetter('r'));

        st.setWord("pizza");
        Assertions.assertEquals(GameState.GAME, st.guessLetter('p'));
        Assertions.assertEquals(GameState.GAME, st.guessLetter('i'));
        Assertions.assertEquals(GameState.GAME, st.guessLetter('z'));
        Assertions.assertEquals(GameState.WIN, st.guessLetter('a'));
        Assertions.assertEquals(GameState.WIN, st.guessLetter('r'));

        StandartManager defManager = new StandartManager();
        defManager.setWord("pizza");
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('p'));
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('q'));
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('q'));
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('q'));
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('q'));
        Assertions.assertEquals(GameState.LOSE, defManager.guessLetter('q'));
        Assertions.assertEquals(GameState.LOSE, defManager.guessLetter('r'));

        defManager.setWord("pizza");
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('p'));
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('i'));
        Assertions.assertEquals(GameState.GAME, defManager.guessLetter('z'));
        Assertions.assertEquals(GameState.WIN, defManager.guessLetter('a'));
        Assertions.assertEquals(GameState.WIN, defManager.guessLetter('r'));
    }

    @Test
    public void testSetWord() {
        HangmanWords smallHWord = new StandartHangmanWord("asd");
        HangmanWords optHWord = new StandartHangmanWord("sdfgj");
        HangmanWords longHWord = new StandartHangmanWord("afgjkurtteryutukyhg");

        StandartManager manager = new StandartManager(5, new VoidRepresenter());

        manager.setWord(optHWord);
        Assertions.assertEquals(optHWord, manager.getWord());

        manager.setWord("asdfg");
        Assertions.assertEquals(new StandartHangmanWord("asdfg"), manager.getWord());

        Assertions.assertThrows(
            TooLongWordException.class,
            () -> manager.setWord(longHWord)
        );

        Assertions.assertThrows(
            TooLongWordException.class,
            () -> manager.setWord("asdqweerttiyjhgvbn")
        );

        Assertions.assertThrows(
            TooSmallWordException.class,
            () -> manager.setWord(smallHWord)
        );

        Assertions.assertThrows(
            TooSmallWordException.class,
            () -> manager.setWord("as")
        );
    }
}
