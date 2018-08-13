package com.eltex.model.product;

import com.eltex.model.Producer;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Scanner;

public class ToolProduct extends ProductAbstract {

    private String type;

    public ToolProduct() {
    }

    public ToolProduct(String type) {
        this.type = type;
    }

    public ToolProduct(String name, String type) {
        super(name);
        this.type = type;
    }

    public ToolProduct(String name, VendorCode code, String type) {
        super(name, code);
        this.type = type;
    }

    public ToolProduct(String name, VendorCode code, double cost, String type) {
        super(name, code, cost);
        this.type = type;
    }

    public ToolProduct(String name, VendorCode vendorCode, double cost, Producer producer, String type) {
        super(name, vendorCode, cost, producer);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void create() {
        super.create();

        type = RandomStringUtils.random(5,true, false);
    }

    @Override
    public void delete() {
        super.delete();

        type = null;
    }

    @Override
    public void update() {
        super.update();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type: ");
        type = scanner.next();
    }

    @Override
    public void read() {
        super.read();

        System.out.println("Type: " + type);
    }
}
