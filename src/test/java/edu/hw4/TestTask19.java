package edu.hw4;

import edu.hw4.Errors.HeightError;
import edu.hw4.Errors.NameError;
import edu.hw4.Errors.ValidateError;
import edu.hw4.Errors.WeightError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask19 {
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

        Set<ValidateError> set1 = new HashSet<>();
        set1.add(new NameError("Se"));
        Set<ValidateError> set2 = new HashSet<>();
        set2.add(new HeightError("Suise"));
        set2.add(new WeightError("Suise"));
        Map<String, Set<ValidateError>> expected = new HashMap<>() {{
            put("Se", set1);
            put("Suise", set2);
        }};

        Assertions.assertEquals(expected, Tasks.task19(l));
    }
}
