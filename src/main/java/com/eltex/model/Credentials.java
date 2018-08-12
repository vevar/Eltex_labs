package com.eltex.model;

import java.util.UUID;

public class Credentials {

    private UUID id;
    private String firstName;
    private String secondName;
    private String grandName;
    private String email;

    public Credentials() {
    }

    public Credentials(String firstname, String secondname, String grandname, String email) {
        this.firstName = firstname;
        this.secondName = secondname;
        this.grandName = grandname;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGrandName() {
        return grandName;
    }

    public void setGrandName(String grandName) {
        this.grandName = grandName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
