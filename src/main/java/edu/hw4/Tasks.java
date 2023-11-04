package edu.hw4;

import edu.hw4.Errors.ValidateError;
import java.util.*;
import java.util.stream.Collectors;

public class Tasks {

    private Tasks() {
    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> task2(List<Animal> animals, int k) {
        return animals
            .stream()
            .sorted((b1, b2) -> -Integer.compare(b1.weight(), b2.weight()))
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals
            .stream()
            .map(Animal::type)
            .collect(
                Collectors
                    .groupingBy(x -> x, Collectors.summingInt(x -> 1))
            );
    }

    public static Animal task4(List<Animal> animals) {
        Animal first = animals.get(0);
        return animals
            .stream()
            .reduce(
                first,
                (prev, next) ->
                    prev.name().length() >= next.name().length() ? prev : next
            );
    }

    public static Animal.Sex task5(List<Animal> animals) {
        if (
            animals
                .stream()
                .filter((beast) -> beast.sex() == Animal.Sex.M)
                .count()
                >=
                animals
                    .stream()
                    .filter((beast) -> beast.sex() == Animal.Sex.F)
                    .count()
        ) {
            return Animal.Sex.M;
        }

        return Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals
            .stream()
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.reducing(
                        new Animal("", Animal.Type.DOG, Animal.Sex.M, 0, 0, -1, false),
                        (b1, b2) -> b1.weight() >= b2.weight() ? b1 : b2
                    )
                )
            );
    }

    public static Animal task7(List<Animal> animals, int k) {
        var col = animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::age))
            .limit(k)
            .toList();

        if (col.size() == 0) {
            return null;
        }

        if (k > col.size()) {
            return col.get(col.size() - 1);
        }

        return col.get(k - 1);
    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals
            .stream()
            .filter((x) -> x.height() < k)
            .max(Comparator.comparingInt(Animal::weight));

    }

    public static Integer task9(List<Animal> animals) {
        return animals
            .stream()
            .map(Animal::paws)
            .reduce(0, Integer::sum);
    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals
            .stream()
            .filter((r) -> r.paws() != r.age())
            .toList();
    }

    public static List<Animal> task11(List<Animal> animals) {
        return animals
            .stream()
            .filter((r) -> r.bites() && r.height() > 100)
            .toList();
    }

    public static Integer task12(List<Animal> animals) {
        return Math.toIntExact(animals
            .stream()
            .filter((r) -> r.weight() > r.height())
            .count()
        );
    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals
            .stream()
            .filter((beast) -> beast.name().split(" ").length > 2)
            .toList();
    }

    public static Boolean task14(List<Animal> animals, int k) {
        return animals
            .stream()
            .anyMatch((b) -> b.type() == Animal.Type.DOG && b.height() > k);
    }

    public static Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int i) {
        return animals
            .stream()
            .filter((b) -> b.age() <= i && b.age() >= k)
            .collect(
                Collectors.groupingBy(
                    Animal::type,
                    Collectors.summingInt(Animal::weight)
                )
            );

    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals
            .stream()
            .sorted(
                (b1, b2) -> {
                    if (b1.type().compareTo(b2.type()) != 0) {
                        return b1.type().compareTo(b2.type());
                    }

                    if (b1.sex().compareTo(b2.sex()) != 0) {
                        return b1.sex().compareTo(b2.sex());
                    }

                    return b1.name().compareTo(b2.name());
                }
            )
            .toList();
    }

    public static Boolean task17(List<Animal> animals) {
        return animals
            .stream()
            .map((b) -> {
                if (b.type() == Animal.Type.SPIDER && b.bites()) {
                    return 1;
                }
                if (b.type() == Animal.Type.DOG && b.bites()) {
                    return -1;
                }
                return 0;
            }).reduce(0, Integer::sum) > 0;
    }

    public static Animal task18(List<List<Animal>> listsAnimals) {
        return listsAnimals
            .stream()
            .map(x ->
                x
                    .stream()
                    .filter((y) -> y.type() == Animal.Type.FISH)
                    .reduce(new Animal(
                            "",
                            Animal.Type.FISH,
                            Animal.Sex.F,
                            -1,
                            -1,
                            -1,
                            true
                        ), (beast1, beast2) -> beast1.weight() > beast2.weight() ? beast1 : beast2
                    )
            )
            .reduce(
                new Animal(
                    "",
                    Animal.Type.FISH,
                    Animal.Sex.F,
                    -1,
                    -1,
                    -1,
                    true
                ), (beast1, beast2) -> beast1.weight() > beast2.weight() ? beast1 : beast2
            );
    }

    public static Map<String, Set<ValidateError>> task19(List<Animal> animals) {
        return animals
            .stream()
            .flatMap((beast) -> Validator.validate(beast).stream())
            .collect(
                Collectors.groupingBy(
                    ValidateError::getBeastName,
                    Collectors.toSet()
                )
            );
    }

    public static Map<String, String> task20(List<Animal> animals) {
        return animals
            .stream()
            .flatMap((beast) -> Validator.validate(beast).stream())
            .collect(
                Collectors.groupingBy(
                    ValidateError::getBeastName,
                    Collectors.reducing(
                        "",
                        (v) -> v.getClass().getName(),
                        (b1, b2) -> {
                            String[] s = b2.split("\\.");
                            return b1 + s[s.length - 1] + '\n';
                        }
                    )
                )
            );
    }
}
