package edu.hw6.task3;

import java.nio.file.Path;

public class ComposeFilter implements  AbstractFilter{
    private final AbstractFilter filter1;
    private final AbstractFilter filter2;

    public ComposeFilter(AbstractFilter f1, AbstractFilter f2){
        filter1 = f1;
        filter2 = f2;
    }

    @Override
    public boolean accept(Path path) {
        return filter1.accept(path) && filter2.accept(path);
    }
}
