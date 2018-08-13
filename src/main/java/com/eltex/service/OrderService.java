package com.eltex.service;

import com.eltex.model.OrderSingleton;
import com.eltex.model.shop.Order;

import java.util.List;
import java.util.UUID;

/**
 * Service for orders
 * @author alxminyaev
 * @see OrderSingleton
 */
public class OrderService {

    public  static void add(Order order){
        OrderSingleton.getInstance().checkout(order);
    }

    public static void remove(Order order){
        OrderSingleton.getInstance().remove(order);
    }

    public static Order getOrder(UUID id){
        return OrderSingleton.getInstance().getOrder(id);
    }

    public static List getAll(){
        return OrderSingleton.getInstance().getListOrders();
    }
}
