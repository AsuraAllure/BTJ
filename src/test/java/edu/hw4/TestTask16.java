package edu.hw4;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask16 {
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
            ),
            new Animal(
                "Riko",
                Animal.Type.DOG,
                Animal.Sex.F,
                10,
                140,
                9,
                true
            ),
            new Animal(
                "Euler",
                Animal.Type.SPIDER,
                Animal.Sex.F,
                4,
                1,
                2,
                true
            ),
            new Animal(
                "Euler Leonard Gaussovich",
                Animal.Type.SPIDER,
                Animal.Sex.F,
                4,
                1,
                2,
                true
            )
        );

        List<Animal> expectedList = List.of(
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
                "Bera",
                Animal.Type.DOG,
                Animal.Sex.M,
                15,
                50,
                25,
                true
            ),
            new Animal(
                "Riko",
                Animal.Type.DOG,
                Animal.Sex.F,
                10,
                140,
                9,
                true
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
                "LiShi",
                Animal.Type.FISH,
                Animal.Sex.M,
                2,
                10,
                6,
                false
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
                "Uki",
                Animal.Type.SPIDER,
                Animal.Sex.M,
                1,
                3,
                1,
                true
            ),

            new Animal(
                "Euler",
                Animal.Type.SPIDER,
                Animal.Sex.F,
                4,
                1,
                2,
                true
            ),
            new Animal(
                "Euler Leonard Gaussovich",
                Animal.Type.SPIDER,
                Animal.Sex.F,
                4,
                1,
                2,
                true
            )
        );
        Assertions.assertEquals(expectedList, Tasks.task16(l));
    }
}
