package edu.hw2.ConnectionTask;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String mes, Throwable cause) {
        super(mes, cause);
    }

    public ConnectionException() {
        super();
    }
}
