package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TestTask3 {
    @Test
    public void testTask3() {
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
                1,
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

        Map<Animal.Type, Integer> res = Tasks.task3(l);

        Assertions.assertEquals(5, res.keySet().size());
        Assertions.assertEquals(1, res.get(Animal.Type.DOG));
        Assertions.assertEquals(1, res.get(Animal.Type.CAT));
        Assertions.assertEquals(1, res.get(Animal.Type.BIRD));
        Assertions.assertEquals(1, res.get(Animal.Type.FISH));
        Assertions.assertEquals(2, res.get(Animal.Type.SPIDER));
    }
}
