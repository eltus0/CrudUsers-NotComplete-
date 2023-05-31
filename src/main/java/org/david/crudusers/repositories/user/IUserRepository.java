package org.david.crudusers.repositories.user;

import org.david.crudusers.models.User;
import org.david.crudusers.repositories.IRepository;

import java.sql.SQLException;
import java.util.Optional;

/**
 * DAO de users
 */
public interface IUserRepository extends IRepository<User> {

//    Optional<String> onlyName() throws SQLException;

    Optional<User> byUk(String uk) throws SQLException;

    Optional<User> byCountry(String country) throws SQLException;

    Optional<User> byGeneroFav(String generoFav) throws SQLException;
}
