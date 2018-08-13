package com.eltex.model;

import com.eltex.model.shop.Order;
import com.eltex.model.shop.Orders;


/**
 * Singleton for
 *
 * @author alxminyaev
 * @see Orders
 * @see Order
 */
public class OrderSingleton {
    static Orders<Order> instance;

    /**
     * @return list of orders
     */
    public static Orders<Order> getInstance() {
        if (instance == null) {
            synchronized (OrderSingleton.class) {
                if (instance == null) {
                    instance = new Orders<>();
                }
            }
        }
        return instance;
    }
}
