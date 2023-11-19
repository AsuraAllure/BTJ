package edu.hw6.task3;

import java.nio.file.Path;

public class SizeFilter implements AbstractFilter {
    public final int MAX_SIZE_FILE;
    public final int MIN_SIZE_FILE;

    public SizeFilter(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }

        MAX_SIZE_FILE = size;
        MIN_SIZE_FILE = 0;
    }

    public SizeFilter(int minSize, int maxSize) {
        // Разные исключения - разные сообщения
        if (maxSize < minSize || minSize < 0) {
            throw new IllegalArgumentException();
        }
        MAX_SIZE_FILE = maxSize;
        MIN_SIZE_FILE = minSize;
    }

    @Override
    public boolean accept(Path path) {
        return path.toFile().length() >= MIN_SIZE_FILE && path.toFile().length() <= MAX_SIZE_FILE;
    }
}
