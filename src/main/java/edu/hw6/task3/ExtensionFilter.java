package edu.hw6.task3;

import java.nio.file.Path;

public class ExtensionFilter implements AbstractFilter {
    private final String EXTENSION;
    public ExtensionFilter(String extension){
        if (extension == null)
            throw new NullPointerException();
        if (extension.length() == 0 || extension.length() > 3)
            throw new IllegalArgumentException();
        this.EXTENSION = extension;
    }

    @Override
    public boolean accept(Path path) {
        return path.toString().endsWith(EXTENSION);
    }
}
