package org.david.crudusers.models.listaenlazado;

import org.david.crudusers.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Lista enlazadas de parientes del usuario
 */
public class ParentList implements IParentList{

    private Nodo primer;

    private int size;

    public ParentList() {
        this.size = 0;
        this.primer = null;
    }

    @Override
    public void addLast(User user) {
        if (primer == null) {
            primer = new Nodo(user);;
        } else {
            primer = new Nodo(user, primer);
        }
        ++this.size;
    }

    @Override
    public void addFirst(User user) {
        Nodo nodo = new Nodo(user);
        if (this.primer == null) {
            this.primer = nodo;
        } else {
            Nodo actual = this.primer;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nodo);
        }
        ++size;
    }

    @Override
    public void deleteLast() {
        if (primer == null) {
            System.out.println("Empty List");
        } else {
            primer = primer.getNext();
            --size;
        }
    }

    @Override
    public void deleteFirst() {
        if (primer == null) {
            System.out.println("Empty List");
        } else {
            Nodo actual = this.primer;
            while (actual.getNext() != null) {
                if (actual.getNext().getNext() == null){
                    actual.setNext(null);
                    break;
                }
                actual = actual.getNext();
            }
            --size;
        }
    }

    @Override
    public void delete(String name) {
        if (primer == null) {
            System.out.println("Empty List");
        } else {
            if (primer.getParent().getName().equalsIgnoreCase(name)){
                this.primer = this.primer.getNext();
                --size;
            } else {
                Nodo actual = this.primer;
                while (actual.getNext() != null && !actual.getNext().getParent().getName().equalsIgnoreCase(name)) {
                    actual = actual.getNext();
                }
                if (actual.getNext() == null) {
                    System.out.println("Element Not Found");
                } else {
                    actual.setNext(actual.getNext().getNext());
                    --size;
                }
            }
        }
    }

    @Override
    public List<User> searchAll(String nameParent) {
        List<User> users = new ArrayList<>();
        if (primer == null){
            System.out.println("Empty List");
        } else {
            Nodo nodo = this.primer;
            while (nodo != null) {
                if (nodo.getParent().getName().equalsIgnoreCase(nameParent)) {
                    users.add(nodo.getParent());
                }
                nodo = nodo.getNext();
            }
        }
        return users;
    }

    @Override
    public Optional<User> search(String nameParent) {
        Optional<User> user = Optional.empty();
        if (this.primer == null) {
            user = Optional.empty();
        } else {
            Nodo actual = this.primer;
            while (actual != null) {
                if (actual.getParent().getName().equalsIgnoreCase(nameParent)){
                    user = Optional.of(actual.getParent());
                    break;
                }
                actual = actual.getNext();
            }
        }
        return user;
    }

    @Override
    public String toString() {
        return "ParentList{" +
                "primer=" + primer +
                ", size=" + size +
                '}';
    }
}
