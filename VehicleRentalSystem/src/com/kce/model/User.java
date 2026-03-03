package com.kce.model;

public class User {

    private int id;
    private String name;
    private String username;
    private String password;
    private String role;

    public User(int id, String name, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setName(String name) { this.name = name; }

    public void display() {
        System.out.println("ID: " + id + " Name: " + name + " Role: " + role);
    }
}