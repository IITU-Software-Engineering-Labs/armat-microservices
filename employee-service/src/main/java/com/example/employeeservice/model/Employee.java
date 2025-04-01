package com.example.employeeservice.model;

public class Employee {
    private int id;
    private String name;
    private String favoriteColor;

    public Employee(int id, String name, String favoriteColor) {
        this.id = id;
        this.name = name;
        this.favoriteColor = favoriteColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
