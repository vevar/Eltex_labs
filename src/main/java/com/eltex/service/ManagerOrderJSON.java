package com.eltex.service;

import com.eltex.model.OrderSingleton;
import com.eltex.model.shop.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Class for implementation IO orders to JSONFile
 *
 * @author alxminyaev
 * @see AManageOrder
 * @see IOrder
 */
public class ManagerOrderJSON extends AManageOrder {

    private static String path = "src/main/resources/objects/json/";
    private static String tmpNameFile = "Order_";
    private static String type = ".json";

    /**
     * Read json file by id
     *
     * @param id UUID id of order
     * @return order
     */
    @Override
    public Order readById(UUID id) {
        ObjectMapper mapper = new ObjectMapper();
        File folder = new File(path);
        File[] files = folder.listFiles();

        Order order = null;
        String nameFile;
        if (files != null) {
            for (File file : files) {
                nameFile = file.getName();
                if (nameFile.matches(tmpNameFile + id.toString() + type)) {
                    try {
                        order = mapper.readValue(nameFile, Order.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }

        return order;
    }

    /**
     * Save order by id to json file
     *
     * @param id UUID id of order
     */
    @Override
    public void saveById(UUID id) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = OrderSingleton.getInstance().getOrder(id);
        File file = new File(path + tmpNameFile + order.getId().toString() + type)
                .getAbsoluteFile();

        try {
            mapper.writeValue(file, order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read all json file
     *
     * @return order
     */
    @Override
    public List<Order> readAll() {
        File folder = new File(path);
        File[] files = folder.listFiles();
        ObjectMapper mapper = new ObjectMapper();

        Order order;
        List<Order> orderList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {

                if (file.getName().matches(String.format("%s.*[.]json", tmpNameFile))) {
                    try {
                        order = mapper.readValue(file, Order.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        continue;
                    }
                    orderList.add(order);
                }

            }
        }
        return orderList;
    }

    /**
     * Save all orders to json files
     */
    @Override
    public void saveAll() {
        ObjectMapper mapper = new ObjectMapper();
        List orders = OrderService.getAll();

        String beginNameFile = path + tmpNameFile;
        String fullNameFile;
        for (Object order : orders) {
            fullNameFile = beginNameFile + ((Order) order).getId().toString() + type;

            try {
                mapper.writeValue(new File(fullNameFile), orders);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
