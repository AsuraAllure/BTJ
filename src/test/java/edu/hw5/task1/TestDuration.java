package edu.hw5.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDuration {

    @Test
    public void testTime() {
        List<String> l = new ArrayList<>();
        l.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        l.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        Assertions.assertEquals("PT3H40M", Analytics.analise(l));
    }

    @Test
    public void testNull() {

        NullPointerException exp = Assertions.assertThrows(NullPointerException.class, () -> Analytics.analise(null));
        Assertions.assertEquals(
            NullPointerException.class,
            exp.getClass()
        );
    }

    @Test
    public void testZeroVisitors() {
        List<String> l = new ArrayList<>();
        Assertions.assertEquals("No visitors", Analytics.analise(l));
    }

}
