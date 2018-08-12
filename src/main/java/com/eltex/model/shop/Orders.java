package com.eltex.model.shop;

import java.time.LocalDateTime;
import java.util.*;

public class Orders<T extends Order> {

    private List<T> orderList;
    private Map<LocalDateTime, T> orderMap;


    public Orders() {
        orderList = new LinkedList<>();
        orderMap = new LinkedHashMap<>();
    }

    public Orders(List<T> orderList, Map<LocalDateTime, T> orderMap) {
        this.orderList = orderList;
        this.orderMap = orderMap;
    }


    public void checkout(T order) throws NullPointerException{
        if (order == null){
            throw new NullPointerException("Oder is null");
        }

        order.setDateCreation(LocalDateTime.now());

        orderList.add(order);
        orderMap.put(order.getDateCreation(), order);

    }

    public boolean remove(T order) {
        if (order == null){
            throw new NullPointerException("Oder is null");
        }

        boolean removeFlag = orderList.remove(order);
        orderMap.remove(order.getDateCreation());
        return removeFlag;
    }



    public T getOrder(UUID id) {
        if (id == null){
            throw new NullPointerException("Id is null");
        }

        for (T order : orderList) {
            if (order.getId() == id)
                return order;
        }

        return null;
    }

    public List getListOrders() {
        return orderList;
    }

    public Map<LocalDateTime, T> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<LocalDateTime, T> orderMap) {
        this.orderMap = orderMap;
    }
}
