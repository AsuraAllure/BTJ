package edu.project1;

import edu.project1.GameEnum.GameState;
import edu.project1.Managers.StandartManager;
import edu.project1.Representers.VoidRepresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestManager {
    @Test
    public void testStandartManager(){
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
    }
}
