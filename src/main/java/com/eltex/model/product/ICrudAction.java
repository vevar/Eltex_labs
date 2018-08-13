package com.eltex.model.product;

public interface ICrudAction {
    /**
     * Create product with random parameters
     */
    void create();

    /**
     * Delete all parameters of product
     */
    void delete();

    /**
     * Input parameter of product
     */
    void update();

    /**
     * Output parameter of product
     */
    void read();

}
