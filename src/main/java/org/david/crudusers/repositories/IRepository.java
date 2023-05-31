package org.david.crudusers.repositories;

import org.david.crudusers.models.Country;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    List<T> atList() throws SQLException;

    Optional<T> byId(Integer id) throws SQLException;

    T save(T t) throws SQLException;

    void delete(T t) throws SQLException;
}
