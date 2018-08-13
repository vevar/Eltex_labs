package com.eltex.model.shop;

import java.io.IOException;
import java.util.UUID;

/**
 * IO Interface for order
 *
 * @author alxminyaev
 */
public interface IOrder {


    /**
     * Read order by id
     * @param id
     */
    static void readById(UUID id) {
    }

    /**
     * Save order by id
     * @param id
     * @throws IOException
     */
    static void saveById(UUID id) throws IOException {
    }

    /**
     *Read all orders
     */
    static void readAll() {
    }

    /**
     * Save all orders
     */
    static void saveAll() {
    }

 }