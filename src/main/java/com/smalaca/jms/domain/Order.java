package com.smalaca.jms.domain;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = -797586847427389162L;

    private final String orderNumber;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public boolean hasOrderNumberEquals(String orderNumber) {
        return getOrderNumber().equals(orderNumber);
    }
}
