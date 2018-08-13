package com.eltex.model.factory;

import com.eltex.model.product.ProductAbstract;

/**
 * Interface discretion of product factory
 *
 * @author alxminyaev
 * @see ProductFactory
 */
public interface ProductFactoryInterface {

    static ProductAbstract createProduct(int type) {
        return null;
    }

}
