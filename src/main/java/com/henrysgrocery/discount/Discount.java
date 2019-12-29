package com.henrysgrocery.discount;

import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;

public class Discount {
    private static final LocalDate VALIDATE_FROM = LocalDate.now().plusDays(3);
    private static final LocalDate VALIDATE_TO = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    private static BigDecimal DISCOUNT_FACTOR = BigDecimal.valueOf(0.10);

    public BigDecimal getDiscount(Map.Entry<Item, Integer> item, LocalDate purchaseDate) {

        if (item.getKey() == Item.APPLE && isDiscountValid(VALIDATE_FROM, VALIDATE_TO, purchaseDate)) {
            return item.getKey().getCost()
                    .multiply(new BigDecimal(item.getValue()))
                    .multiply(DISCOUNT_FACTOR);
        }

        return BigDecimal.ZERO;
    }

    private static boolean isDiscountValid(LocalDate validateFrom, LocalDate validateTo, LocalDate purchaseDate) {

        return (purchaseDate.isAfter(validateFrom) || purchaseDate.isEqual(validateFrom)) &&
                (purchaseDate.isBefore(validateTo) || purchaseDate.isEqual(validateTo));
    }
}
