package edu.project1;

import edu.project1.Dictionary.Dictionary;
import edu.project1.Dictionary.EmptyDicionaryEception;
import edu.project1.Dictionary.StandartDictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDict {
    @Test
    public void testStandardDictionary(){
        Dictionary dic = new StandartDictionary();

        Assertions.assertEquals("pizza", dic.getWord());
        Assertions.assertEquals("pineapple", dic.getWord());
        Assertions.assertEquals("cake", dic.getWord());
        Assertions.assertThrows(EmptyDicionaryEception.class, dic::getWord);

        dic.refresh();
        Assertions.assertEquals("pizza", dic.getWord());

        dic.refresh();
        Assertions.assertEquals("pizza", dic.getWord());
    }
}
