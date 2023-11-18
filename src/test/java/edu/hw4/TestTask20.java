package edu.hw4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask20 {
    @Test
    public void test() {
        List<Animal> l = List.of(
            new Animal(
                "Se",
                Animal.Type.FISH,
                Animal.Sex.F,
                100,
                100,
                100,
                true
            ),
            new Animal(
                "Suise",
                Animal.Type.FISH,
                Animal.Sex.F,
                100,
                -1,
                -1,
                true
            )
        );

        Map<String, String> exp = new HashMap<>();
        exp.put("Suise", """
            HeightError
            WeightError
            """);
        exp.put("Se", """
            NameError
            """);

        Assertions.assertEquals(exp, Tasks.task20(l));

    }
}
