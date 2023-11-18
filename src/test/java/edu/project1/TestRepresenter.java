package edu.project1;

import edu.project1.Representers.Readers.TestReader;
import edu.project1.Representers.StandartRepresenter;
import edu.project1.Representers.Writers.TestWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRepresenter {
    @Test
    public void testStandartRepresenter() {
        ArrayList<String> output = new ArrayList<>();
        List<String> input = List.of(new String[] {"asd"});
        StandartRepresenter st = new StandartRepresenter(new TestWriter(output), new TestReader(input));

        st.print("Hello");
        Assertions.assertEquals("Hello", output.get(0));
        st.hitMessage();
        Assertions.assertEquals("Hit!", output.get(1));
        st.missMessage(1, 5);
        Assertions.assertEquals("Missed, mistake 1 out of 5.", output.get(2));
        st.guessMessage();
        Assertions.assertEquals("Guess a letter:", output.get(3));
        st.loseMessage();
        Assertions.assertEquals("You lost!", output.get(4));
        st.winMessage();
        Assertions.assertEquals("You won!", output.get(5));
        st.printReprWord("asd");
        Assertions.assertEquals("The word: asd", output.get(6));
        Assertions.assertEquals("asd", st.input());
    }
}
