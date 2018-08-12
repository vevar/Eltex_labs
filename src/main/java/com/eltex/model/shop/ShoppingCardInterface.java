package com.eltex.model.shop;

import java.util.List;
import java.util.UUID;

public interface ShoppingCardInterface<T> {

    void add(T product);
    void delete(T product);

    List<T> getListProduct();
}
