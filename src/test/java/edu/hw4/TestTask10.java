package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTask10 {
    @Test
    public void test() {
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
                4,
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

        Assertions.assertEquals(
            List.of(
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
            ),
            Tasks.task10(l)
        );
    }
}
