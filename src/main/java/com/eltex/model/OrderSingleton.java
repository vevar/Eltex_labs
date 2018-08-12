package com.eltex.model;

import com.eltex.model.shop.Order;
import com.eltex.model.shop.Orders;

public class OrderSingleton {
    static Orders<Order> instance;

    public static Orders<Order> getInstance(){
        if (instance == null){
            synchronized(OrderSingleton.class){
                if (instance == null){
                    instance = new Orders<>();
                }
            }
        }
        return instance;
    }
}
