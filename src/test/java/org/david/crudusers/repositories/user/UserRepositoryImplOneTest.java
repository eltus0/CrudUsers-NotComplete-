package org.david.crudusers.repositories.user;

import org.david.crudusers.models.GenFav;
import org.david.crudusers.models.User;
import org.david.crudusers.repositories.country.CountryRepositoryImplOne;
import org.david.crudusers.repositories.country.ICountryRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplOneTest {

    private final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "sasa");
    private final IUserRepository repo = new UserRepositoryImplOne(conn);

    private final ICountryRepository repoc = new CountryRepositoryImplOne(conn);

    UserRepositoryImplOneTest() throws SQLException {
    }

//falta por probar con datos
    @Test
    public void enlist(){
        try {
             repo.atList().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byId() throws SQLException {
        System.out.println(repo.byId(54).get());
    }

    @Test
    public void saveSave() throws SQLException {
        User parent = new User();
        parent.setId(52L);
        User user = new User(0L, "sdafsdaf", "asdda", "eltudasdasds0", "asdas", "eqwe", 20, new Date(), new Date(), new Date(), repoc.byName("Mexico").get(), GenFav.Electronica, parent, false);
        System.out.println(repo.save(user));
    }

    @Test
    public void saveUpdate() throws SQLException {
        User user = repo.byId(54).get();
        user.setUk("54da87eq");
        repo.save(user);
    }

    @Test
    public void delete () throws SQLException {
        User user = new User();
        user.setId(51L);
        repo.delete(user);
    }
}