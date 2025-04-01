package com.example.addressservice.model;

public class Address {
    private int employeeId;
    private String street;
    private String city;
    private String country;

    public Address(int employeeId, String street, String city, String country) {
        this.employeeId = employeeId;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
