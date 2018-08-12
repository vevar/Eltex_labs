package com.eltex.model.shop;

import com.eltex.model.Credentials;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {

    private UUID id;
    private ShoppingCard shoppingCard;
    private StatusOrder statusOrder;
    private LocalDateTime dateCreation;
    private Duration dateWait;
    private Credentials user;


    private Order() {
        id = UUID.randomUUID();
    }

    public Order(ShoppingCard shoppingCard) {
        this();
        this.shoppingCard = shoppingCard;
    }

    public Order(ShoppingCard shoppingCard, Credentials user) {
        this();
        this.shoppingCard = shoppingCard;
        this.user = user;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }


    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Duration getDateWait() {
        return dateWait;
    }

    public void setDateWait(Duration dateWait) {
        this.dateWait = dateWait;
    }


    public Credentials getUser() {
        return user;
    }

    public void setUser(Credentials user) {
        this.user = user;
    }

    public void checkout() {
        dateCreation = LocalDateTime.now();
    }

}
