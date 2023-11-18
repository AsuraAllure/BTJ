package edu.hw6.task3;

import java.nio.file.Path;

public class WritableFilter implements AbstractFilter {

    @Override
    public boolean accept(Path path) {
        return path.toFile().canWrite();
    }
}
