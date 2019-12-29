package com.henrysgrocery.discount;

import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class DefaultDiscount implements Discount {

    @Override
    public BigDecimal getDiscount(Map<Item, Integer> items, Map.Entry<Item, Integer> discountItem, LocalDate purchaseDate) {

        return BigDecimal.ZERO;
    }

}
