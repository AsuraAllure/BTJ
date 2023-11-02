package edu.hw2.ConnectionTask.Connections;

import edu.hw2.ConnectionTask.ConnectionException;

public class FaultyConnection implements Connection {
    private final static double RATE_FAULTY_CONNECTION = 0.7;

    @Override
    public void execute(String command) {
        if (Math.random() > RATE_FAULTY_CONNECTION) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
    }
}
