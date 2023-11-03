package edu.project1.HangmanWords;

import edu.project1.GameEnum.GuessEnum;

public class StandartHangmanWord implements HangmanWords {
    private final String guessWord;
    private final char[] representWord;

    public StandartHangmanWord(String guessWord) {
        this.guessWord = guessWord;
        this.representWord = guessWord.replaceAll("\\w{1}", "*").toCharArray();
    }

    @Override
    public GuessEnum guess(Character a) {
        GuessEnum res = GuessEnum.MISS;
        for (int i = 0; i < guessWord.length(); i += 1) {
            if (guessWord.charAt(i) == a) {
                representWord[i] = guessWord.charAt(i);
                res = GuessEnum.HIT;
            }
        }
        return res;
    }

    @Override
    public int getLength() {
        return guessWord.length();
    }

    @Override
    public String getRepresentWord() {
        StringBuilder str = new StringBuilder();
        for (var c : representWord) {
            str.append(c);
        }
        return str.toString();
    }

    @Override
    public boolean isGuessed() {
        for (var c : representWord) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }
}
