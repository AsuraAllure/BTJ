package edu.project1.Representers.Writers;

import java.util.List;

public class TestWriter implements Writer {
    private final List<String> out;

    public TestWriter(List<String> output) {
        out = output;
    }

    @Override
    public void print(String s) {
        out.add(s);
    }
}
