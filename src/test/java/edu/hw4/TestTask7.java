package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTask7 {

    @Test
    public void testTask7() {
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
        Assertions.assertEquals(new Animal(
            "Koi",
            Animal.Type.SPIDER,
            Animal.Sex.M,
            1,
            3,
            2,
            true
        ), Tasks.task7(l, 2));

        Assertions.assertEquals(new Animal(
            "Uki",
            Animal.Type.SPIDER,
            Animal.Sex.M,
            1,
            3,
            1,
            true
        ), Tasks.task7(l, 1));

        Assertions.assertEquals(new Animal(
            "Bera",
            Animal.Type.DOG,
            Animal.Sex.M,
            15,
            50,
            25,
            true
        ), Tasks.task7(l, 6));

    }
}
