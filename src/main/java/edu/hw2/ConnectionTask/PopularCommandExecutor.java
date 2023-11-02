package edu.hw2.ConnectionTask;

import edu.hw2.ConnectionTask.Connections.Connection;
import edu.hw2.ConnectionTask.Managers.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) {
        for (int j = 0; j < maxAttempts; j += 1) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException conExc) {
                if (j == maxAttempts - 1) {
                    throw new ConnectionException("Сonnection attempt limit exceeded", conExc);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
