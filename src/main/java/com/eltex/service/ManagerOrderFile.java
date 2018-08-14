package com.eltex.service;

import com.eltex.model.shop.Order;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * Class for implementation IO orders to file
 * @author alxminyaev
 * @see AManageOrder
 * @see IOrder
 */
public class ManagerOrderFile extends AManageOrder {

    private final static String type = "File";
    private final static String path = "objects/file";

    @Override
    public Order readById(UUID id) {
        return null;
    }

    @Override
    public void saveById(UUID id) throws IOException {

    }

    @Override
    public List<Order> readAll() {
        return null;
    }

    @Override
    public void saveAll(){

    }
}
