package edu.hw6.task3.AttributeFilter;

import edu.hw6.task3.AbstractFilter;

import java.nio.file.Files;
import java.nio.file.Path;

public class ReadableFilter implements AbstractFilter {
    @Override
    public boolean accept(Path path) {
        return Files.isReadable(path);
    }
}
