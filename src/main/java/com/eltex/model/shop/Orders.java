package com.eltex.model.shop;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Collection of orders
 *
 * @param <T>
 * @author alxminyaev
 * @see Order
 * @see Map
 * @see List
 */
public class Orders<T extends Order> {

    private List<T> orderList;
    private Map<LocalDateTime, T> orderMap;


    public Orders() {
        orderList = new LinkedList<>();
        orderMap = new LinkedHashMap<>();
    }

    /**
     * @param orderList
     * @param orderMap
     */
    public Orders(List<T> orderList, Map<LocalDateTime, T> orderMap) {
        this.orderList = orderList;
        this.orderMap = orderMap;
    }

    /**
     * Add order to collection
     *
     * @param order order
     * @throws NullPointerException
     */
    public synchronized void checkout(T order) throws NullPointerException {
        if (order == null) {
            throw new NullPointerException("Oder is null");
        }

        order.setDateCreation(LocalDateTime.now());

        orderList.add(order);
        orderMap.put(order.getDateCreation(), order);

    }

    /**
     * Remove order from collection
     *
     * @param order order
     * @return boolean value
     */
    public boolean remove(T order) {
        if (order == null) {
            throw new NullPointerException("Oder is null");
        }

        boolean removeFlag = orderList.remove(order);
        orderMap.remove(order.getDateCreation());
        return removeFlag;
    }


    /**
     * Get order by id
     *
     * @param id id
     * @return
     * @see UUID
     */
    public T getOrder(UUID id) {
        if (id == null) {
            throw new NullPointerException("Id is null");
        }

        for (T order : orderList) {
            if (order.getId() == id)
                return order;
        }

        return null;
    }

    /**
     * @return Get list of orders
     */
    public List getListOrders() {
        return orderList;
    }

    /**
     * @return Get map of order
     */
    public Map<LocalDateTime, T> getOrderMap() {
        return orderMap;
    }

    /**
     * Set map of order
     *
     * @param orderMap
     */
    public void setOrderMap(Map<LocalDateTime, T> orderMap) {
        this.orderMap = orderMap;
    }
}
