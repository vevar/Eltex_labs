package com.eltex.model;

import com.eltex.model.shop.Order;
import com.eltex.model.shop.Orders;
import com.eltex.model.shop.ShoppingCard;

import java.util.UUID;

/**
 * Client of shop
 */
public class Credentials {

    private UUID id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String email;
    private ShoppingCard shoppingCard;
    private Orders<Order> orders;

    public Credentials() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Orders<Order> getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
