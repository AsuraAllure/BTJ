package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    public static final int COUNT_PAWS_CAT = 4;
    public static final int COUNT_PAWS_DOG = 4;
    public static final int COUNT_PAWS_BIRD = 2;
    public static final int COUNT_PAWS_FISH = 0;
    public static final int COUNT_PAWS_SPIDER = 8;
    public int paws() {
        return switch (type) {
            case CAT -> COUNT_PAWS_CAT;
            case DOG -> COUNT_PAWS_DOG;
            case BIRD -> COUNT_PAWS_BIRD;
            case FISH -> COUNT_PAWS_FISH;
            case SPIDER -> COUNT_PAWS_SPIDER;
        };
    }

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }
}
