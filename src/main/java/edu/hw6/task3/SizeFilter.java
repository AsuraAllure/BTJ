package edu.hw6.task3;

import java.nio.file.Path;

public class SizeFilter implements AbstractFilter {
    public final int maxSizeFile;
    public final int minSizeFile;

    public SizeFilter(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }

        maxSizeFile = size;
        minSizeFile = 0;
    }

    public SizeFilter(int minSize, int maxSize) {
        // Разные исключения - разные сообщения
        if (maxSize < minSize || minSize < 0) {
            throw new IllegalArgumentException();
        }
        maxSizeFile = maxSize;
        minSizeFile = minSize;
    }

    @Override
    public boolean accept(Path path) {
        return path.toFile().length() >= minSizeFile && path.toFile().length() <= maxSizeFile;
    }
}
