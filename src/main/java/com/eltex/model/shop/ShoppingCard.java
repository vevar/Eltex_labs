package com.eltex.model.shop;

import com.eltex.model.product.ProductAbstract;

import java.util.*;

public class ShoppingCard <T extends ProductAbstract> implements ShoppingCardInterface<T> {

    private List<T> listProduct;
    private Set<UUID> uuidSet;


    public ShoppingCard() {
        listProduct = new ArrayList<>();
        uuidSet = new TreeSet<>();

    }

    @Override
    public void add(T product) {
        while (uuidSet.contains(product.getId())) {
            product.setId(UUID.randomUUID());
        }

        uuidSet.add(product.getId());
        listProduct.add(product);

    }

    @Override
    public void delete(T product) {
        listProduct.remove(product);
    }

    @Override
    public List<T> getListProduct() {
        return listProduct;
    }
}
