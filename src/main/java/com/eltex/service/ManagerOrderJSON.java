package com.eltex.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * Class for implementation IO orders to file
 *
 * @author alxminyaev
 * @see AManageOrder
 * @see com.eltex.model.shop.IOrder
 */
public class ManagerOrderJSON extends AManageOrder {

    private final static String type = "json";
    private final static String path = "files/json";

    @Override
    public static void readById(UUID id) {

    }

    @Override
    public static void saveById(UUID id) {

    }

    @Override
    public static void readAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List orders = OrderService.getAll();
        String nameFile = path + "/" + type;
        mapper.writeValue(new File(nameFile), orders);
    }

    @Override
    public static void saveAll() {

    }
}
