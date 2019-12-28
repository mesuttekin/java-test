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

    public void addCart(String item) {

        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1);
        } else {
            items.put(item, 1);
        }
    }
}
