package com.henrysgrocery.discount;

import com.henrysgrocery.factory.DiscountFactory;
import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class ApplyDiscount {

    public BigDecimal getDiscount(Map<Item, Integer> items, Map.Entry<Item, Integer> discountItem, LocalDate purchaseDate) {

        return DiscountFactory.getDiscountInstance(discountItem.getKey()).getDiscount(items, discountItem, purchaseDate);
    }


}
