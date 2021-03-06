package com.eltex.model.shop;

import com.eltex.model.product.ProductAbstract;

import java.io.Serializable;
import java.util.*;

/**
 * Shopping card (basket)
 * @param <T>
 *
 * @author alxminyaev
 * @see ProductAbstract
 * @see ShoppingCardInterface
 */
public class ShoppingCard <T extends ProductAbstract> implements ShoppingCardInterface<T>, Serializable {

    private List<T> listProduct;
    private Set<UUID> uuidSet;


    public ShoppingCard() {
        listProduct = new ArrayList<>();
        uuidSet = new TreeSet<>();
    }

    /**
     * Add product to shopping card
     * @param product product
     * @throws NullPointerException Will throw an error if the argument is null.
     */
    @Override
    public void add(T product) throws NullPointerException{
        if (product == null){
            throw new NullPointerException("Product is null");
        }

        while (uuidSet.contains(product.getId())) {
            product.setId(UUID.randomUUID());
        }

        uuidSet.add(product.getId());
        listProduct.add(product);

    }

    /**
     * Delete product form shopping card
     * @param product product
     */
    @Override
    public void delete(T product) {
        listProduct.remove(product);
    }

    /**
     * @return Get list of product
     */
    @Override
    public List<T> getListProduct() {
        return listProduct;
    }
}
