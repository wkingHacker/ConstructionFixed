package com.hunau.bean;

/**
 * @author Wking
 * @create 2020-12-04 9:06
 */
public class User {
    String username;
    String password;
    String role;
    int id;

    public User() {
    }

    public User(String username, String password, String role, int id) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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





    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" +role + '\'' +
                ", id=" + id +
                '}';
    }
}
