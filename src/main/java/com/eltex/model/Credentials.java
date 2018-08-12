package com.eltex.model;

import com.eltex.model.shop.ShoppingCard;

import java.util.UUID;

public class Credentials {

    private UUID id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String email;
    private ShoppingCard shoppingCard;


    public Credentials() {

    }

    public Credentials(String firstname, String secondname, String grandname, String email) {
        this.firstName = firstname;
        this.secondName = secondname;
        this.middleName = grandname;
        this.email = email;
    }

    public Credentials(String firstName, String secondName, String middleName, String email,
                       ShoppingCard shoppingCard) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.email = email;
        this.shoppingCard = shoppingCard;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }
}
