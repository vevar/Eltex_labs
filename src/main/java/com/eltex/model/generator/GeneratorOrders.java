package com.eltex.model.generator;

import com.eltex.model.factory.ProductFactory;
import com.eltex.model.product.ProductAbstract;
import com.eltex.model.shop.Order;
import com.eltex.model.shop.ShoppingCard;
import com.eltex.service.OrderService;

import java.time.Duration;
import java.time.LocalDateTime;


/**
 * Class for generation orders. It run like demon {@link Thread}
 * <p>
 * For manage of generation use {@link #on()} and {@link #off}
 *
 * @author alxminyaev
 * @see Runnable
 * @see Thread
 */
public class GeneratorOrders implements Runnable {

    private Thread thread;
    private static final int GENERATION_INTERVAL = 100;
    private boolean fWork;
    private boolean lock;
    private Duration timeBetweenGeneration;
    private LocalDateTime lastTime;


    public GeneratorOrders() {
        thread = new Thread(this);
        thread.setDaemon(true);
        timeBetweenGeneration = Duration.ofNanos(GENERATION_INTERVAL);
        lastTime = LocalDateTime.now();
    }

    /**
     * @return boolean value if {@link GeneratorOrders} running return <i>true</i> else return false
     */
    public boolean isWork() {
        return fWork;
    }

    /**
     * Method run this generator
     */
    public synchronized void on() {
        fWork = true;
        thread.start();
    }

    /**
     * Method stop this generator
     */
    public synchronized void off() {
        fWork = false;
        notify();
    }

    /**
     * @return <i>true</i> if generator wait, else <i>false</i>
     */
    public boolean isLock() {
        return lock;
    }

    /**
     * Set lock of generator
     *
     * @param lock <i>true</i> if generator wait, else <i>false</i>
     */
    public synchronized void setLock(boolean lock) {
        this.lock = lock;

        if (!this.lock) {
            notify();
        }
    }

    /**
     * Interval of time between generation
     *
     * @return Time between generation
     */
    public Duration getTimeBetweenGeneration() {
        return timeBetweenGeneration;
    }

    /**
     * Set time between generation
     *
     * @param timeBetweenGeneration Interval of time between generation
     */
    public void setTimeBetweenGeneration(Duration timeBetweenGeneration) {
        this.timeBetweenGeneration = timeBetweenGeneration;
    }

    /**
     * Main method for thread work like loop at Thread
     * @throws InterruptedException
     */
    private void loop() throws InterruptedException {
        while (fWork) {
            while (lock) {
                synchronized (this) {
                    wait();
                }
            }

            if (isTimeGeneration()) {
                generate();
                lastTime = LocalDateTime.now();
            }
        }
    }

    /**
     * Check time of generation
     */
    private boolean isTimeGeneration() {
        return lastTime.plus(timeBetweenGeneration).isBefore(LocalDateTime.now());
    }

    /**
     * Method that generate product
     */
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
