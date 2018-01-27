package com.example.demo.domain.entities;

import com.example.demo.common.Guard;
import com.example.demo.domain.Entity;

import java.util.Date;

public class User implements Entity {
    private long id;
    private Date creationDate;
    private Date updateDate;
    private String name;
    private String login;
    private String email;
    private String password;

    public User() {

    }

    public User(String name, String login, String email, String password) throws Exception {
        setName(name);
        setLogin(login);
        setEmail(email);
        setPassword(password);
    }


    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Date getCreationDate() {
        return this.creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public Date getUpdateDate() {
        return this.updateDate;
    }

    @Override
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        Guard.forNullOrEmpty(name, "");
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws Exception {
        Guard.forNullOrEmpty(login, "");
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        Guard.forNullOrEmpty(email, "");
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        Guard.forNullOrEmpty(password, "");
        this.password = password;
    }

}
