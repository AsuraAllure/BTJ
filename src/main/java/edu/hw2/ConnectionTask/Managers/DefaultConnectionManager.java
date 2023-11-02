package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.ConnectionException;
import edu.hw2.ConnectionTask.Connections.Connection;
import edu.hw2.ConnectionTask.Connections.FaultyConnection;
import edu.hw2.ConnectionTask.Connections.StableConnection;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() throws ConnectionException {
        if (Math.random() > 0.7) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
