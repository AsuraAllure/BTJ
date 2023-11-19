package edu.hw6.task3;

import java.nio.file.Path;

public class ExtensionFilter implements AbstractFilter {

    private final String extension;
    private static final int MIN_LENGTH_EXT = 3;
    private static final int MAX_LENGTH_EXT = 4;
    public ExtensionFilter(String extension) {
        if (extension == null) {
            throw new NullPointerException();
        }
        if (extension.length() < MIN_LENGTH_EXT || extension.length() > MAX_LENGTH_EXT) {
            throw new IllegalArgumentException();
        }
        this.extension = extension;
    }

    @Override
    public boolean accept(Path path) {
        return path.toString().endsWith(extension);
    }
}
