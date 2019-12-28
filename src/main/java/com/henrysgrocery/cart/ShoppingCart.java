package com.henrysgrocery.cart;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, Integer> items;

    public ShoppingCart() {
        this.items = new LinkedHashMap<>();
    }

    public Map<String, Integer> getItems(){

        return items;
    }
}
