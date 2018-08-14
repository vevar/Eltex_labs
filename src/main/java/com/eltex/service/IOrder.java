package com.eltex.service;

import com.eltex.model.shop.Order;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * IO Interface for order
 *
 * @author alxminyaev
 */
public interface IOrder {

    /**
     * Read order by id
     *
     * @param id
     */
    Order readById(UUID id);

    /**
     * Save order by id
     *
     * @param id
     * @throws IOException
     */
    void saveById(UUID id) throws IOException;

    /**
     * Read all orders
     */
    List<Order> readAll();

    /**
     * Save all orders
     */
    void saveAll() throws IOException;

}