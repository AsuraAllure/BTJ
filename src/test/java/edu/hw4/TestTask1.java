package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class TestTask1 {
    @Test
    public void testTask1() {
        List<Animal> expectedList = List.of(
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
            )
        );
        Assertions.assertEquals(expectedList, Tasks.task1(toSortList));
        Assertions.assertEquals(new LinkedList<>(), Tasks.task1(new LinkedList<>()));
    }
}
