package edu.hw6.task3;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class RegexFilter implements AbstractFilter{

    private final Pattern pattern;

    public RegexFilter(Pattern pat){
        if (pat == null)
            throw new NullPointerException();

        pattern = pat;
    }

    @Override
    public boolean accept(Path path) {
        return pattern.matcher(path.toString()).find();
    }
}
