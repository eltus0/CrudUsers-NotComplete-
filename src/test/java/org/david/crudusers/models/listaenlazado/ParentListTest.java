package org.david.crudusers.models.listaenlazado;

import org.david.crudusers.models.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParentListTest {

    private static IParentList parentList;

    private static User user1 = new User();

    private static User user2 = new User();

    private static User user3 = new User();

    private static User user4 = new User();

    private static User user5 = new User();

    @BeforeEach
    public void Users(){
        user1.setName("David");
        user2.setName("Daniel");
        user2.setAge(30);
        user3.setName("daniel");
        user4.setName("david");
        user4.setAge(20);
        user5.setName("Romina");
    }

    @BeforeEach
    public void llenar_list(){
        parentList = new ParentList();
        parentList.addLast(user1);
        parentList.addLast(user2);
        parentList.addLast(user3);
        parentList.addLast(user4);
        parentList.addLast(user5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"david", "daniel","Elia", "Hector"})
    public void add(String name){
        User user = new User();
        user.setName(name);

        parentList.addLast(user);
        System.out.println(parentList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"david", "daniel","Elia", "Hector"})
    public void addfirst(String name){
        User user = new User();
        user.setName(name);

        User userfirst = new User();
        userfirst.setName(name + "dasdas");

        parentList.addLast(user);
        parentList.addFirst(userfirst);
        System.out.println(parentList);
    }

    @Test
    public void deleteLast(){
        System.out.println(parentList);
        parentList.deleteLast();
        System.out.println(parentList);
    }

    @Test
    public void deleteFirst(){
        System.out.println(parentList);
        parentList.deleteFirst();
        System.out.println(parentList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"david","daniel","romina","fasdfasd"})
    public void deleteByName(String name){
        System.out.println(parentList);
        parentList.delete(name);
        System.out.println(parentList);
    }

    @ParameterizedTest
    @ValueSource(strings = {"david","daniel","romina","fasdfasd"})
    public void searchList(String nombre){
        System.out.println(parentList);
        parentList.searchAll(nombre).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"david","daniel","romina","fasdfasd"})
    public void search(String nameParent){
        System.out.println(parentList.search(nameParent).get());
    }
}