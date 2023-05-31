package org.david.crudusers.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IService<T>{

    List<T> atList() throws SQLException;

    T byId(Integer id) throws SQLException;

    T save(T t) throws SQLException;

    void delete(Integer id) throws SQLException;
}
