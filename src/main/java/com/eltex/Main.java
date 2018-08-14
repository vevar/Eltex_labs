package com.eltex;

import com.eltex.model.factory.ProductFactory;
import com.eltex.model.generator.GeneratorOrders;
import com.eltex.model.product.ProductAbstract;
import com.eltex.model.shop.Order;
import com.eltex.service.OrderService;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        GeneratorOrders generator1 = new GeneratorOrders();
        GeneratorOrders generator2 = new GeneratorOrders();
        generator1.on();
        generator2.on();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                generator1.setLock(true);
                generator2.setLock(true);
                List<Order> orders = OrderService.getAll();
                synchronized (OrderService.getAll()) {
                    for (Order order : orders) {
                        for (Object product : order.getShoppingCard().getListProduct()) {
                            ((ProductAbstract) product).read();
                            System.out.println();

                        }
                    }
                }
                generator1.off();
                generator2.off();
                System.out.println(orders.size());
//                new ManagerOrderJSON().saveAll();
            }
        }, 1000);


    }

    private void lab1(String[] args) {
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
