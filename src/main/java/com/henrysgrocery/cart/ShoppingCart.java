package com.henrysgrocery.cart;

import com.henrysgrocery.discount.Discount;
import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<Item, Integer> items;
    private final Discount discount;
    private final LocalDate purchaseDate;

    public ShoppingCart(Discount discount, LocalDate purchaseDate) {
        this.items = new EnumMap<>(Item.class);
        this.discount = discount;
        this.purchaseDate = purchaseDate;
    }

    public Map<Item, Integer> getItems() {

        return items;
    }

    public void addCart(Item item, Integer quantity) {

        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public void addCart(Item item) {

        addCart(item, 1);
    }

    public BigDecimal getTotal() {

        return items.entrySet()
                        .stream()
                        .map(this::getItemCost)
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO);

    }

    private BigDecimal getItemCost(Map.Entry<Item, Integer> item) {
        return item.getKey().getCost()
                .multiply(new BigDecimal(item.getValue()))
                .subtract(discount.getDiscount(item, purchaseDate));
    }



}
