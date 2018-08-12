package com.eltex.model.product;

import com.eltex.model.Producer;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Scanner;

public class BuildingMaterialProduct extends ProductAbstract {

    private String type;
    private double weight;

    public BuildingMaterialProduct() {
    }

    public BuildingMaterialProduct(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    public BuildingMaterialProduct(String name, String type, double weight) {
        super(name);
        this.type = type;
        this.weight = weight;
    }

    public BuildingMaterialProduct(String name, VendorCode code, String type, double weight) {
        super(name, code);
        this.type = type;
        this.weight = weight;
    }

    public BuildingMaterialProduct(String name, VendorCode code, double cost, String type, double weight) {
        super(name, code, cost);
        this.type = type;
        this.weight = weight;
    }

    public BuildingMaterialProduct(String name, VendorCode vendorCode, double cost,
                                   Producer producer, String type, double weight) {
        super(name, vendorCode, cost, producer);
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void create() {
        super.create();
        type = RandomStringUtils.random(5);
        weight = Math.random() * 100;
    }

    @Override
    public void delete() {
        super.delete();

        type = null;
        weight = 0;
    }

    @Override
    public void update() {
        super.update();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input type:");
        type = scanner.next();

        System.out.println("Input weight:");
        weight = scanner.nextInt();
    }

    @Override
    public void read() {
        super.read();

        System.out.println("Type: " + type);
        System.out.println("Weight: " + weight);

    }
}
