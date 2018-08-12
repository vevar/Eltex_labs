package com.eltex.model.generator;

import com.eltex.model.factory.ProductFactory;
import com.eltex.model.product.ProductAbstract;
import com.eltex.model.shop.Order;
import com.eltex.model.shop.ShoppingCard;
import com.eltex.service.OrderService;

import java.time.Duration;
import java.time.LocalDateTime;

public class GeneratorOrders extends Thread {

    private static final int GENERATION_INTERVAL = 100;
    private boolean fWork;
    private boolean lock;
    private Duration timeBetweenGeneration;
    private LocalDateTime lastTime;

    public boolean isWork() {
        return fWork;
    }

    public void setWork(boolean fWork) {
        this.fWork = fWork;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Duration getTimeBetweenGeneration() {
        return timeBetweenGeneration;
    }

    public void setTimeBetweenGeneration(Duration timeBetweenGeneration) {
        this.timeBetweenGeneration = timeBetweenGeneration;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    private void loop() throws InterruptedException {
        if (timeBetweenGeneration == null) {
            timeBetweenGeneration = Duration.ofNanos(GENERATION_INTERVAL);
        }
        if (lastTime == null){
            lastTime = LocalDateTime.now();
        }

        while (fWork) {
            while (lock) {
                wait();
            }

            if (isTimeGeneration()) {
                generate();
                lastTime = LocalDateTime.now();
            }
        }
    }

    private boolean isTimeGeneration() {
        return lastTime.plus(timeBetweenGeneration).isBefore(LocalDateTime.now());
    }

    private synchronized void generate() {
        int amountProduct = (int) (Math.random() * 10) + 1;
        ShoppingCard shoppingCard = new ShoppingCard();

        int type;

        for (int i = 0; i < amountProduct; i++) {
            type = (int) (Math.random() * 10) % 3;
            ProductAbstract product = null;

            switch (type) {
                case 0:
                    product = ProductFactory.createProduct(ProductFactory.PRODUCT_PAINT);
                    break;
                case 1:
                    product = ProductFactory.createProduct(ProductFactory.PRODUCT_TOOL);
                    break;
                case 2:
                    product = ProductFactory.createProduct(ProductFactory.PRODUCT_BUILD_MATERIAL);
                    break;
            }

            if (product == null) {
                throw new NullPointerException("Product is null!");
            }

            product.create();
            shoppingCard.add(product);
        }

        OrderService.add(new Order(shoppingCard));
    }

    @Override
    public void run() {
        fWork = true;
        try {
            loop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
