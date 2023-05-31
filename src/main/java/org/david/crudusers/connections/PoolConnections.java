package org.david.crudusers.connections;

import org.apache.commons.dbcp2.BasicDataSource;
import org.david.crudusers.erros.connection.ConnectionsException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Pool de conecciones
 *
 * evitar la saturaccion de las conneciones
 *
 * usando el patron singleton
 */
public class PoolConnections {

    private final BasicDataSource bds;

    private static PoolConnections pool;

    private PoolConnections() {
        this.bds = new BasicDataSource();
        this.bds.setUrl("jdbc:mysql://localhost");
        this.bds.setUsername("root");
        this.bds.setPassword("sasa");
        this.bds.setInitialSize(3);
        this.bds.setMaxTotal(5);
        this.bds.setMaxWaitMillis(5000);
        this.bds.setMaxIdle(7);
        this.bds.setMinIdle(1);
    }

    public Connection getConnection() {
        try {
            return this.bds.getConnection();
        } catch (SQLException e) {
            throw new ConnectionsException(e.getMessage());
        }
    }

    public static PoolConnections getInstance(){
        if (pool == null) {
            pool = new PoolConnections();
        }
        return pool;
    }
}
