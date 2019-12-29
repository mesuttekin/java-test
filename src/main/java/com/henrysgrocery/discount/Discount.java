package com.henrysgrocery.discount;

import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;

import static com.henrysgrocery.item.Item.*;

public class Discount {
    private static final LocalDate VALIDATE_FROM = LocalDate.now().plusDays(3);
    private static final LocalDate VALIDATE_TO = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    private static BigDecimal DISCOUNT_FACTOR = BigDecimal.valueOf(0.10);

    private static final LocalDate VALIDATE_FROM_BREAD = LocalDate.now().minusDays(1);
    private static final LocalDate VALIDATE_TO_BREAD = LocalDate.now().plusDays(7);
    private static final int SOUP_QUANTITY_FOR_DISCOUNT = 2;
    private static final BigDecimal DISCOUNT_FACTOR_BREAD = BigDecimal.valueOf(2);


    public BigDecimal getDiscount(Map<Item, Integer> items, Map.Entry<Item, Integer> discountItem, LocalDate purchaseDate) {

        if (items == null || discountItem == null || purchaseDate == null) {
            return BigDecimal.ZERO;
        }


        if (discountItem.getKey() == APPLE && isDiscountValid(VALIDATE_FROM, VALIDATE_TO, purchaseDate)) {
            return discountItem.getKey().getCost()
                    .multiply(new BigDecimal(discountItem.getValue()))
                    .multiply(DISCOUNT_FACTOR);
        } else if (discountItem.getKey() == BREAD && items.containsKey(SOAP) && isDiscountValid(VALIDATE_FROM_BREAD, VALIDATE_TO_BREAD, purchaseDate)) {

            return discountItem.getKey().getCost()
                    .multiply(BigDecimal.valueOf(Integer.min(items.get(BREAD), items.get(SOAP) / SOUP_QUANTITY_FOR_DISCOUNT)))
                    .divide(DISCOUNT_FACTOR_BREAD);
        }

        return BigDecimal.ZERO;

    }

    private static boolean isDiscountValid(LocalDate validateFrom, LocalDate validateTo, LocalDate purchaseDate) {

        return (purchaseDate.isAfter(validateFrom) || purchaseDate.isEqual(validateFrom)) &&
                (purchaseDate.isBefore(validateTo) || purchaseDate.isEqual(validateTo));
    }
}
