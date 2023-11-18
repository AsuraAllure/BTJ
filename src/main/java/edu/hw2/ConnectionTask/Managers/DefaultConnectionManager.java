package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.ConnectionException;
import edu.hw2.ConnectionTask.Connections.Connection;
import edu.hw2.ConnectionTask.Connections.FaultyConnection;
import edu.hw2.ConnectionTask.Connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {
    private final static double RATE_FAULTY_CONNECTION = 0.7;

    @Override
    public Connection getConnection() throws ConnectionException {
        if (Math.random() > RATE_FAULTY_CONNECTION) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
