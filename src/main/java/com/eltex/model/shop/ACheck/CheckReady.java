package com.eltex.model.shop.ACheck;

import com.eltex.model.shop.Order;
import com.eltex.model.shop.Orders;
import com.eltex.model.shop.StatusOrder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;

public class CheckReady extends ACheck {

    private Orders orders;

    public CheckReady(Orders orders) {
        timeBetweenCheck = Duration.ofMinutes(1);
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    void check() {
        Iterator iterator = orders.getListOrders().iterator();

        while (iterator.hasNext()){
            Order order = (Order) iterator.next();

            if ( order.getStatusOrder() == StatusOrder.READY ){
                iterator.remove();
                orders.getOrderMap().remove(order.getDateCreation());
            }
        }
    }
}
