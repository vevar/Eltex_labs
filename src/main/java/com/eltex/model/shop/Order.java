package com.eltex.model.shop;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Description of order
 *
 * @author alxminyaev
 * @see Serializable
 * @see UUID
 */
public class Order implements Serializable {

    private UUID id;
    private ShoppingCard shoppingCard;
    private StatusOrder statusOrder;
    private LocalDateTime dateCreation;
    private Duration dateWait;


    private Order() {
        id = UUID.randomUUID();
    }

    public Order(ShoppingCard shoppingCard) {
        this();
        this.shoppingCard = shoppingCard;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    /**
     *
     * @return Get id
     * @see UUID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Get shopping card
     * @return shopping card
     */
    public ShoppingCard getShoppingCard() {
        return shoppingCard;
    }

    /**
     * Get status of order
     * @return status
     */
    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    /**
     * Set status order
     * @param statusOrder
     */
    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    /**
     * Set date or creation
     * @param dateCreation
     */
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get date and time of creation
     * @return
     */
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    /**
     * Get duration of wait
     * @return
     */
    public Duration getDateWait() {
        return dateWait;
    }

    /**
     * Set duration of wait
     * @param dateWait
     */
    public void setDateWait(Duration dateWait) {
        this.dateWait = dateWait;
    }

}
