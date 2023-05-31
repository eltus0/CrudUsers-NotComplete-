package org.david.crudusers.erros.connection;

/**
 * Exception personalizada para el pool de connections
 */
public class ConnectionsException extends RuntimeException{

    public ConnectionsException(String message) {
        super(message);
    }
}
