package com.henrysgrocery.item;

import java.math.BigDecimal;

public enum Item {
    SOAP(BigDecimal.valueOf(0.65)),
    BREAD(BigDecimal.valueOf(0.80)),
    MILK(BigDecimal.valueOf(1.30)),
    APPLE(BigDecimal.valueOf(0.10));

    private final BigDecimal cost;

    Item(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
