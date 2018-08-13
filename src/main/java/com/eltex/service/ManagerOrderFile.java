package com.eltex.service;

import java.io.IOException;
import java.util.UUID;


/**
 * Class for implementation IO orders to file
 * @author alxminyaev
 * @see AManageOrder
 * @see com.eltex.model.shop.IOrder
 */
public class ManagerOrderFile extends AManageOrder {

    private final static String type = "File";
    private final static String path = "files/file";

    @Override
    public static void readById(UUID id) {

    }

    @Override
    public static void saveById(UUID id) throws IOException {

    }

    @Override
    public static void readAll() {

    }

    @Override
    public static void saveAll() throws IOException {

    }
}
