package com.eltex.model.shop.ACheck;

import com.eltex.model.shop.Order;
import com.eltex.model.shop.Orders;
import com.eltex.model.shop.StatusOrder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;

public class CheckWait extends ACheck {

    private Orders orders;

    public CheckWait(Orders orders) {
        super();
        timeBetweenCheck = Duration.ofMinutes(1);
        this.orders = orders;
    }

    @Override
    void check() {
        Iterator iterator = orders.getListOrders().iterator();

        while (iterator.hasNext()){
            Order order = (Order) iterator.next();

            if ( order.getStatusOrder() == StatusOrder.WAIT &&
                    order.getDateCreation().plus(order.getDateWait()).isBefore(LocalDateTime.now())){
                iterator.remove();
            }
        }
    }
}
