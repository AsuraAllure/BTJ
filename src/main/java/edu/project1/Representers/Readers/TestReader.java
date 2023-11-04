package edu.project1.Representers.Readers;

import java.util.Iterator;
import java.util.List;

public class TestReader implements Reader {
    private final Iterator<String> iterator;

    public TestReader(List<String> in) {
        iterator = in.iterator();
    }

    @Override
    public String read() {
        return iterator.next();
    }
}
