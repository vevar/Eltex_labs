package com.eltex.model.shop;

import java.time.LocalDate;
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


    public void checkout(T order) {
        order.setDateCreation(LocalDateTime.now());

        orderList.add(order);
        orderMap.put(order.getDateCreation(), order);

    }

    public boolean remove(T order) {

        boolean removeFlag = orderList.remove(order);
        orderMap.remove(order.getDateCreation());
        return removeFlag;
    }

    public void check() {
        Iterator<T> iterator = orderList.iterator();
        T order;

        while (iterator.hasNext()) {
            order = iterator.next();

            if (order.getStatusOrder() == StatusOrder.READY &&
                    order.getDateCreation().plus(order.getDateWait()).isBefore(LocalDateTime.now())) {
                iterator.remove();
            }
        }

    }

    public T getOrder(UUID id) {
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
