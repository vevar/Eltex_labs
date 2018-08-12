package com.eltex;

import com.eltex.model.factory.ProductFactory;
import com.eltex.model.product.ProductAbstract;

public class Main {

    public static void main(String[] args) {

        if (args.length == 2) {
            int amountObj = new Integer(args[0]);

            ProductAbstract painProduct;
            int typeObject;

            switch (args[1]) {
                case "p":
                    typeObject = ProductFactory.PRODUCT_PAINT;
                    break;
                case "t":
                    typeObject = ProductFactory.PRODUCT_TOOL;
                    break;
                case "b":
                    typeObject = ProductFactory.PRODUCT_BUILD_MATERIAL;
                    break;
                default:
                    typeObject = -1;
                    break;

            }

            if (typeObject != -1) {
                for (int i = 0; i < amountObj; i++) {
                    painProduct = ProductFactory.createProduct(typeObject);
                    painProduct.create();
                    painProduct.read();
                    System.out.println();
                }
            }
        } else {
            System.out.println("Error");
        }


    }
}
