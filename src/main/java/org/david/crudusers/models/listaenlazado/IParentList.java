package org.david.crudusers.models.listaenlazado;

import org.david.crudusers.models.User;

import java.util.List;
import java.util.Optional;

/**
 * operaciones de las listas enlazadas
 */
public interface IParentList {

    void addLast(User user);

    void addFirst(User user);

    void deleteLast();

    void deleteFirst();

    void delete(String name);

    List<User> searchAll(String nameParent);

    Optional<User> search(String nameParent);

}
