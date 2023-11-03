package edu.project1.HangmanWords;

import edu.project1.GameEnum.GuessEnum;

public interface HangmanWords {
    GuessEnum guess(Character a);
    public int getLength();
    public String getRepresentWord();
    boolean isGuessed();
}
