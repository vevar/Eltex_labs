package com.eltex.service;

import com.eltex.model.OrderSingleton;
import com.eltex.model.shop.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Class for implementation IO orders to file
 *
 * @author alxminyaev
 * @see AManageOrder
 * @see IOrder
 */
public class ManagerOrderFile extends AManageOrder {

    private final static String path = "src/main/resources/objects/file/";
    private final static String type = ".bin";
    private final static String tmpNameFile = "Order_";

    /**
     * Read order by id from binary file.
     * @param id UUID order id
     * @return order
     */

    @Override
    public Order readById(UUID id) {
        File folder = new File(path);
        File[] files = folder.listFiles();

        Order order = null;
        if (files != null) {
            for (File file : files) {

                if (file.getName().matches(tmpNameFile + id.toString() + type)) {
                    try {
                        ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(file));
                        order = (Order) objectIn.readObject();
                        objectIn.close();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }

        return order;
    }

    /**
     * Save order object to binary file
     *
     * @param id UUID id of order
     */
    @Override
    public void saveById(UUID id) {
        Order order = OrderSingleton.getInstance().getOrder(id);

        if (order != null) {
            File file = new File(path + tmpNameFile + id.toString() + type);
            FileOutputStream fileOut = null;

            try {
                fileOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (fileOut != null) {
                try {
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(order);
                    objectOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Read all orders from binary files
     * @return List of orders
     */
    @Override
    public List<Order> readAll() {
        File folder = new File(path);
        File[] files = folder.listFiles();

        Order order;
        List<Order> orderList = new ArrayList<>();
        ObjectInputStream objectIn;
        if (files != null) {
            for (File file : files) {
                try {
                    objectIn = new ObjectInputStream(new FileInputStream(file));
                    order = (Order) objectIn.readObject();
                    objectIn.close();
                    orderList.add(order);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return orderList;
    }

    /**
     * Save all orders to binary file
     */
    @Override
    public void saveAll() {

        List<Order> listOrders = OrderSingleton.getInstance().getListOrders();
        File file = new File(path);

        FileOutputStream fileOut = null;
        for (Order order : listOrders){
            try {
                fileOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            if (fileOut != null) {
                try {
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(order);
                    objectOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
