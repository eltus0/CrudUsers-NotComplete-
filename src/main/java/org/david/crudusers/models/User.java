package org.david.crudusers.models;

import org.david.crudusers.models.listaenlazado.ParentList;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Long id;

    private String uk;

    private String name;

    private String username;

    private String password;

    private String email;

//    poredad
    private Integer age;

    private Date birthday;

    private Date create_at;

    private Date last_update;

    private Country country;

    private GenFav genFav;

    private User parent;

    private boolean notify;

    private ParentList parents;

    public User() {
        this.parents = null;
    }

    public User(Long id, String uk, String name, String username, String password, String email, Integer age, Date birthday
            , Date create_at, Date last_update, Country country, GenFav genFav, User parent, boolean notify) {
        this();
        this.id = id;
        this.uk = uk;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.birthday = birthday;
        this.create_at = create_at;
        this.last_update = last_update;
        this.country = country;
        this.genFav = genFav;
        this.parent = parent;
        this.notify = notify;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public GenFav getGenFav() {
        return genFav;
    }

    public void setGenFav(GenFav genFav) {
        this.genFav = genFav;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public ParentList getParents() {
        return parents;
    }

    public void setParents(ParentList parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uk='" + uk + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", create_at=" + create_at +
                ", last_update=" + last_update +
                ", country=" + country +
                ", genFav=" + genFav +
                ", parent=" + parent +
                ", notify=" + notify +
                '}';
    }
}
