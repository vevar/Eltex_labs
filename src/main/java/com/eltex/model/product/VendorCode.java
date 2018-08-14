package com.eltex.model.product;


import java.io.Serializable;

/**
 * Vendor code for product
 *
 * @author alxminyaev
 */
public class VendorCode implements Serializable {

    private String venCode;

    public VendorCode(String venCode) {
        this.venCode = venCode;
    }

    @Override
    public String toString() {
        return venCode;
    }

    public String getVenCode() {
        return venCode;
    }

    public void setVenCode(String venCode) {
        this.venCode = venCode;
    }
}
