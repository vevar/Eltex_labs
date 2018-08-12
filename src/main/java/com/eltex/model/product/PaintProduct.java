package com.eltex.model.product;

import com.eltex.model.Producer;

import java.awt.*;
import java.util.Scanner;

public class PaintProduct extends ProductAbstract {

    private Color color;

    public PaintProduct() {
    }

    public PaintProduct(Color color) {
        this.color = color;
    }

    public PaintProduct(String name, Color color) {
        super(name);
        this.color = color;
    }

    public PaintProduct(String name, VendorCode code, Color color) {
        super(name, code);
        this.color = color;
    }

    public PaintProduct(String name, VendorCode code, double cost, Color color) {
        super(name, code, cost);
        this.color = color;
    }

    public PaintProduct(String name, VendorCode vendorCode, double cost, Producer producer, Color color) {
        super(name, vendorCode, cost, producer);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void create() {
        super.create();
        color = new Color(
                (int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));

    }

    @Override
    public void delete() {
        super.delete();
        color = null;
    }

    @Override
    public void update() {
        super.update();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Color [R G B]:");

        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();

        color = new Color(r, g, b);
    }

    @Override
    public void read() {
        super.read();
        System.out.println(String.format("Color: (%d, %d, %d)",
                color.getRed(), color.getGreen(), color.getBlue()));

    }
}
