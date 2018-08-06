package com.eltex.model.product;

import com.eltex.model.Producer;

public class BuildingMaterialProduct extends ProductAbstract {

    private String type;
    private double weight;

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
}
