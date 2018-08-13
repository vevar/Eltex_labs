package com.eltex.model.factory;

import com.eltex.model.product.BuildingMaterialProduct;
import com.eltex.model.product.PaintProduct;
import com.eltex.model.product.ProductAbstract;
import com.eltex.model.product.ToolProduct;

/**
 * Patter factory of products
 *
 * @author alxminyaev
 * @see ProductFactoryInterface
 */
public class ProductFactory implements ProductFactoryInterface {
    /**
     * {@value} paint
     */
    public static final int PRODUCT_PAINT = 1;
    /**
     * {@value} tool
     */
    public static final int PRODUCT_TOOL = 2;
    /**
     * {@value} build material
     */
    public static final int PRODUCT_BUILD_MATERIAL = 3;

    /**
     * Method that create of product.
     * If inputted incorrect type parameter, than method return <b>null</b>
     *
     * @param type Type of creating product
     * @return Abstract object of product
     */
    public static ProductAbstract createProduct(int type) {
        switch (type) {
            case PRODUCT_PAINT:
                return new PaintProduct();
            case PRODUCT_TOOL:
                return new ToolProduct();
            case PRODUCT_BUILD_MATERIAL:
                return new BuildingMaterialProduct();
            default:
                return null;
        }
    }

}
