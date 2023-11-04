package edu.project1.Managers;

import edu.project1.GameEnum.GameState;
import edu.project1.GameEnum.GuessEnum;
import edu.project1.HangmanWords.HangmanWords;
import edu.project1.HangmanWords.StandartHangmanWord;
import edu.project1.Representers.Readers.VoidReader;
import edu.project1.Representers.Representer;
import edu.project1.Representers.StandartRepresenter;
import edu.project1.Representers.Writers.VoidWriter;

public class StandartManager implements GameManager {
    public static final int STANDART_COUNT_ERROR = 5;
    private final int maxCountMiss;
    private final int MAX_LENGTH_WORD = 12;
    private final int MIN_LENGTH_WORD = 4;
    private Representer repr;
    private HangmanWords hWord;
    private int curCountMiss = 0;

    public StandartManager() {
        repr = new StandartRepresenter(new VoidWriter(), new VoidReader());
        maxCountMiss = STANDART_COUNT_ERROR;
    }

    public StandartManager(int countStep, Representer repr) {
        maxCountMiss = countStep;
        this.repr = repr;
    }

    @Override
    public HangmanWords getWord() {
        return hWord;
    }

    @Override
    public void setWord(String word) {
        if (word.length() > MAX_LENGTH_WORD) {
            throw new TooLongWordException();
        }
        if (word.length() < MIN_LENGTH_WORD) {
            throw new TooSmallWordException();
        }
        curCountMiss = 0;
        hWord = new StandartHangmanWord(word);
    }

    @Override
    public void setWord(HangmanWords word) {
        if (word.getLength() > MAX_LENGTH_WORD) {
            throw new TooLongWordException();
        }
        if (word.getLength() < MIN_LENGTH_WORD) {
            throw new TooSmallWordException();
        }
        curCountMiss = 0;
        hWord = word;
    }

    @Override
    public void setRepresenter(Representer r) {
        repr = r;
    }

    private GameState checkStartState() {
        if (curCountMiss == maxCountMiss) {
            return GameState.LOSE;
        }

        if (hWord.isGuessed()) {
            return GameState.WIN;
        }

        return GameState.GAME;
    }

    @Override
    public GameState guessLetter(Character a) {
        GameState startState = checkStartState();

        if (startState != GameState.GAME) {
            return startState;
        }

        GuessEnum curState = hWord.guess(a);
        switch (curState) {
            case HIT -> repr.hitMessage();
            case MISS -> {
                curCountMiss += 1;
                repr.missMessage(curCountMiss, maxCountMiss);
            }
            default -> {
            }
        }
        repr.printReprWord(hWord.getRepresentWord());

        if (curCountMiss == maxCountMiss) {
            repr.loseMessage();
            return GameState.LOSE;
        }

        if (hWord.isGuessed()) {
            repr.winMessage();
            return GameState.WIN;
        }
        return GameState.GAME;
    }

}
