package com.eltex.model.factory;

import com.eltex.model.product.BuildingMaterialProduct;
import com.eltex.model.product.PaintProduct;
import com.eltex.model.product.ProductAbstract;
import com.eltex.model.product.ToolProduct;

public class ProductFactory implements ProductFactoryInterface {

    public static final int PRODUCT_PAINT = 1;
    public static final int PRODUCT_TOOL = 2;
    public static final int PRODUCT_BUILD_MATERIAL = 3;

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
