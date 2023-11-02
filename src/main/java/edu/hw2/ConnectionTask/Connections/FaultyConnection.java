package edu.hw2.ConnectionTask.Connections;

import edu.hw2.ConnectionTask.ConnectionException;

public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        if (Math.random() > 0.7) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
    }
}
