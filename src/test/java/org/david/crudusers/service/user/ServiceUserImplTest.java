package org.david.crudusers.service.user;

import org.david.crudusers.tools.service.IUserService;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ServiceUserImplTest {

//    private final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "sasa");
//    private final IUserService service = new ServiceUserImpl(conn);

    ServiceUserImplTest() throws SQLException {
    }

    @Test
    public void pedirBirthday(){
//        System.out.println(service.pedirBirthday("06/25/2002",new Scanner(System.in)));
    }
}