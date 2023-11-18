package edu.hw6.task3.AttributeFilter;

import edu.hw6.task3.AbstractFilter;
import java.nio.file.Path;

public class WritableFilter implements AbstractFilter {

    @Override
    public boolean accept(Path path) {
        boolean b = path.toFile().canWrite();
        return path.toFile().canWrite();
    }
}
