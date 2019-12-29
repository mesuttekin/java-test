package com.henrysgrocery.discount;

import com.henrysgrocery.item.Item;
import com.henrysgrocery.util.DateValidation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import static com.henrysgrocery.item.Item.BREAD;
import static com.henrysgrocery.item.Item.SOUP;

public class BreadDiscount implements Discount {

    private static final LocalDate VALIDATE_FROM = LocalDate.now().minusDays(1);
    private static final LocalDate VALIDATE_TO = LocalDate.now().plusDays(7);
    private static final int SOUP_QUANTITY_FOR_DISCOUNT = 2;
    private static final BigDecimal DISCOUNT_FACTOR = BigDecimal.valueOf(2);


    @Override
    public BigDecimal getDiscount(Map<Item, Integer> items, Map.Entry<Item, Integer> discountItem, LocalDate purchaseDate) {

        if (items == null || discountItem == null || purchaseDate == null) {
            return BigDecimal.ZERO;
        }

        if (discountItem.getKey() == BREAD && items.containsKey(SOUP) && DateValidation.isDiscountValid(VALIDATE_FROM, VALIDATE_TO, purchaseDate)) {

            return discountItem.getKey().getCost()
                    .multiply(BigDecimal.valueOf(Integer.min(items.get(BREAD), items.get(SOUP) / SOUP_QUANTITY_FOR_DISCOUNT)))
                    .divide(DISCOUNT_FACTOR);
        }

        return BigDecimal.ZERO;

    }

}
