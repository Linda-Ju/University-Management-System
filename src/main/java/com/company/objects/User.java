package com.company.objects;
//NOT SURE THAT WE'LL BE USING THIS
public class User {

    private int id;
    private String username;
    private String password;
    private String access;

    public User(){}

    public User(int id, String username, String password, String access) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
