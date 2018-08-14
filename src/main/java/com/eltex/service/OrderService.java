package com.eltex.service;

import com.eltex.model.OrderSingleton;
import com.eltex.model.shop.Order;

import java.util.List;
import java.util.UUID;

/**
 * Service for orders
 *
 * @author alxminyaev
 * @see OrderSingleton
 */
public class OrderService {

    /**
     * It adds order to data
     *
     * @param order order
     */
    public static void add(Order order) {
        OrderSingleton.getInstance().checkout(order);
    }

    /**
     * It removes order from data
     *
     * @param order order
     */
    public static void remove(Order order) {
        OrderSingleton.getInstance().remove(order);
    }

    /**
     * Get order from data
     *
     * @param id UUID id of order
     * @return order
     */
    public static Order getOrder(UUID id) {
        return OrderSingleton.getInstance().getOrder(id);
    }

    /**
     * Get list of orders from data
     *
     * @return list of orders
     */
    public static List<Order> getAll() {
        return OrderSingleton.getInstance().getListOrders();
    }
}
