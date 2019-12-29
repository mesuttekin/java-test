package com.henrysgrocery.item;

import java.math.BigDecimal;

public enum Item {
    SOUP("Soup", BigDecimal.valueOf(0.65)),
    BREAD("Bread", BigDecimal.valueOf(0.80)),
    MILK("Milk", BigDecimal.valueOf(1.30)),
    APPLE("Apple", BigDecimal.valueOf(0.10));

    private final String name;
    private final BigDecimal cost;

    Item(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
