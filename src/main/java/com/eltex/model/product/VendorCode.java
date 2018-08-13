package com.eltex.model.product;


/**
 * Vendor code for product
 *
 * @author alxminyaev
 */
public class VendorCode {

    private String venCode;

    public VendorCode(String venCode) {
        this.venCode = venCode;
    }

    @Override
    public String toString() {
        return venCode;
    }
}
