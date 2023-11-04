package edu.project1;

import edu.project1.Dictionary.Dictionary;
import edu.project1.Dictionary.StandartDictionary;
import edu.project1.GameEnum.GameState;
import edu.project1.Managers.GameManager;
import edu.project1.Managers.StandartManager;
import edu.project1.Representers.Representer;
import edu.project1.Representers.StandartRepresenter;
import java.util.Objects;

public class Hangman {
    private final GameManager manager;
    private final Dictionary dictionary;
    private final Representer representer;

    public Hangman(GameManager manager, Dictionary dict, Representer repr) {
        this.manager = manager;
        this.manager.setRepresenter(repr);
        this.dictionary = dict;
        this.representer = repr;
    }

    public Hangman() {
        this.dictionary = new StandartDictionary();
        this.representer = new StandartRepresenter();
        this.manager = new StandartManager(StandartManager.STANDART_COUNT_ERROR, this.representer);
    }

    public static void main(String[] args) {
        Hangman h = new Hangman();
        h.start();
    }

    public void start() {
        representer.print("It is Hangman game!");
        manager.setWord(dictionary.getWord());
        GameState state = GameState.GAME;
        do {
            representer.guessMessage();
            String inp = representer.input();
            if (Objects.equals(inp, "EXIT")) {
                state = GameState.EXIT;
                continue;
            }
            if (inp.length() != 1) {
                representer.print("Incorrect input");
                continue;
            }
            state = manager.guessLetter(inp.charAt(0));
        } while (state == GameState.GAME);
    }

}
