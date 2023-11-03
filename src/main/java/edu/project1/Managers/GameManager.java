package edu.project1.Managers;

import edu.project1.GameEnum.GameState;
import edu.project1.HangmanWords.HangmanWords;

public interface GameManager {
    HangmanWords getWord();

    void setWord(String word) throws TooLongWordException, TooSmallWordException;

    void setWord(HangmanWords word) throws TooLongWordException, TooSmallWordException;

    GameState guessLetter(Character a);
}
