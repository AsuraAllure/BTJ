package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class TestTask2 {

    @Test
    public void testTask2() {
        List<Animal> expectedList = List.of(
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
                "Shiro",
                Animal.Type.CAT,
                Animal.Sex.M,
                7,
                30,
                15,
                true
            )
        );

        List<Animal> toSortList = List.of(
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
        Assertions.assertEquals(expectedList, Tasks.task2(toSortList, 2));
        Assertions.assertEquals(new LinkedList<>(), Tasks.task2(new LinkedList<>(), 0));
        Assertions.assertEquals(new LinkedList<>(), Tasks.task2(new LinkedList<>(), 2));
    }
}
