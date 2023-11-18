package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTask6 {

    @Test
    public void testTask6() {
        List<Animal> l = List.of(
            new Animal(
                "Uki",
                Animal.Type.SPIDER,
                Animal.Sex.M,
                1,
                3,
                1,
                true
            ),
            new Animal(
                "Koi",
                Animal.Type.SPIDER,
                Animal.Sex.M,
                1,
                3,
                2,
                true
            ),
            new Animal(
                "Shiro",
                Animal.Type.CAT,
                Animal.Sex.M,
                7,
                30,
                15,
                true
            ),
            new Animal(
                "LiShi",
                Animal.Type.FISH,
                Animal.Sex.M,
                2,
                10,
                6,
                false
            ),
            new Animal(
                "Sora",
                Animal.Type.BIRD,
                Animal.Sex.F,
                9,
                15,
                8,
                false
            ),
            new Animal(
                "Bera",
                Animal.Type.DOG,
                Animal.Sex.M,
                15,
                50,
                25,
                true
            )
        );

        Map<Animal.Type, Animal> m = Tasks.task6(l);
        Map<Animal.Type, Animal> expectedMap = new HashMap<>() {{
            put(Animal.Type.SPIDER, new Animal(
                "Koi",
                Animal.Type.SPIDER,
                Animal.Sex.M,
                1,
                3,
                2,
                true
            ));
            put(Animal.Type.DOG, new Animal(
                "Bera",
                Animal.Type.DOG,
                Animal.Sex.M,
                15,
                50,
                25,
                true
            ));
            put(Animal.Type.BIRD, new Animal(
                "Sora",
                Animal.Type.BIRD,
                Animal.Sex.F,
                9,
                15,
                8,
                false
            ));
            put(Animal.Type.FISH, new Animal(
                "LiShi",
                Animal.Type.FISH,
                Animal.Sex.M,
                2,
                10,
                6,
                false
            ));
            put(Animal.Type.CAT, new Animal(
                "Shiro",
                Animal.Type.CAT,
                Animal.Sex.M,
                7,
                30,
                15,
                true
            ));

        }};
        Assertions.assertEquals(expectedMap, m);
    }
}
