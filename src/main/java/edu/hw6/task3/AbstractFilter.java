package edu.hw6.task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    @Override
    boolean accept(Path path);

    default AbstractFilter and(AbstractFilter newFilter) {
        return new ComposeFilter(newFilter, this);
    }

}
