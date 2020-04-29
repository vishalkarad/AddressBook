package com.bridgelabze.model;

public class Person {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;

    public Person() {
    }

    public Person(String firstName, String lastName, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
