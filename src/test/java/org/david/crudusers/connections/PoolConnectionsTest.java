package org.david.crudusers.connections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PoolConnectionsTest {

    @Test
    public void connections(){
        System.out.println(PoolConnections.getInstance().getConnection());
    }


}