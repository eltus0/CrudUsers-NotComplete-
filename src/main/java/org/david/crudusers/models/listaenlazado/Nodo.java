package org.david.crudusers.models.listaenlazado;

import org.david.crudusers.models.User;

public class Nodo {

    private User parent;

    private Nodo next;

    public Nodo(User parent) {
        this.next = null;
        this.parent = parent;
    }

    public Nodo(User parent, Nodo next) {
        this.parent = parent;
        this.next = next;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "parent=" + parent.getName() +
                ", next=" + next +
                '}';
    }
}
