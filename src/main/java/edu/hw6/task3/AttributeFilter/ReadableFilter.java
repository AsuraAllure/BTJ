package edu.hw6.task3.AttributeFilter;

import edu.hw6.task3.AbstractFilter;
import java.io.File;
import java.nio.file.Path;

public class ReadableFilter implements AbstractFilter {
    @Override
    public boolean accept(Path path) {
        File f = path.toFile();
        boolean b = path.toFile().canRead();
        return path.toFile().canRead();
    }
}
