package edu.hw2.ConnectionTask.Managers;

import edu.hw2.ConnectionTask.ConnectionException;
import edu.hw2.ConnectionTask.Connections.Connection;

public interface ConnectionManager {
    Connection getConnection() throws ConnectionException;
}
