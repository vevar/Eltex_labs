package com.eltex.model.product;

import com.eltex.model.Producer;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;


/**
 * Abstract class for products
 *
 * @author alxminyaev
 * @see ICrudAction
 * @see Serializable
 */
public abstract class ProductAbstract implements ICrudAction, Serializable {
    /**
     * Counter of products
     */
    private static int counter;

    private UUID id;
    private String name;
    private VendorCode vendorCode;
    private double cost;
    private Producer producer;

    ProductAbstract() {
        this(null);
    }

    public ProductAbstract(String name) {
        this(name, null);
    }

    ProductAbstract(String name, VendorCode code) {
        this(name, code, 0);
    }

    ProductAbstract(String name, VendorCode code, double cost) {
        this(name, code, cost, null);
    }

    public ProductAbstract(String name, VendorCode vendorCode, double cost, Producer producer) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.vendorCode = vendorCode;
        this.cost = cost;
        this.producer = producer;
    }

    public static int getCounter() {
        return counter;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorCode getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(VendorCode vendorCode) {
        this.vendorCode = vendorCode;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void create() {
        name = RandomStringUtils.random(10,true, false);
        vendorCode = new VendorCode(RandomStringUtils.random(5,true, false));
        cost = (int) (Math.random() * 10000) + 100;
        producer = new Producer(RandomStringUtils.random(10, true, false));

        counter++;
    }

    public void delete() {
        name = null;
        vendorCode = null;
        cost = 0;
        producer = null;

        counter--;
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name: ");
        name = scanner.next();

        System.out.println("Vendor code: ");
        vendorCode = new VendorCode(scanner.next());

        System.out.println("Cost: ");
        cost = scanner.nextDouble();

        System.out.println("Producer: ");
        producer = new Producer(scanner.next());
    }

    public void read() {

        System.out.println("Name: " + name);

        System.out.println("Vendor code: " + vendorCode.toString());

        System.out.println("Cost: " + cost);

        System.out.println("Producer: " + producer.getName());
    }
}
