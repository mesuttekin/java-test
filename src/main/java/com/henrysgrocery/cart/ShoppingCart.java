package com.henrysgrocery.cart;

import com.henrysgrocery.item.ItemType;

import java.util.EnumMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<ItemType, Integer> items;

    public ShoppingCart() {
        this.items = new EnumMap<>(ItemType.class);
    }

    public Map<ItemType, Integer> getItems() {

        return items;
    }

    public void addCart(ItemType item) {

        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1);
        } else {
            items.put(item, 1);
        }
    }
}
