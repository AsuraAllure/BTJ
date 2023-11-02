package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.ConnectionException;
import edu.hw2.ConnectionTask.Connections.Connection;
import edu.hw2.ConnectionTask.Connections.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() throws ConnectionException {
        return new FaultyConnection();
    }
}
