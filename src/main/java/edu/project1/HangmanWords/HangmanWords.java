package edu.project1.HangmanWords;

import edu.project1.GameEnum.GuessEnum;

public interface HangmanWords {
    GuessEnum guess(Character a);

    int getLength();

    String getRepresentWord();

    String getGuessWord();

    boolean isGuessed();
}
