package com.eltex.service;

import com.eltex.model.shop.IOrder;

/**
 * Abstract class for IO orders
 * @author alxminyaev
 * @see IOrder
 */
abstract class AManageOrder implements IOrder {
    protected final static String templateName = "Order";

}
