package com.eltex.model.shop;

import java.util.List;

/**
 * Interface of shopping card
 *
 * @param <T>
 * @author alxminyaev
 */
public interface ShoppingCardInterface<T> {
    /**
     * Add to shopping card
     * @param product
     */
    void add(T product);

    /**
     * Delete from shopping card
     * @param product
     */
    void delete(T product);

    /**
     * Get list of products
     * @return
     */
    List<T> getListProduct();
}
