package edu.project1.Dictionary;

public interface Dictionary {
    String getWord() throws EmptyDicionaryEception;

    void refresh();
}
