package edu.hw2.ConnectionTask.Connections;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
