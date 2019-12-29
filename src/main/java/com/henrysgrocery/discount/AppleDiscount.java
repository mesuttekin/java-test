package com.henrysgrocery.discount;

import com.henrysgrocery.item.Item;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;

import static com.henrysgrocery.item.Item.APPLE;
import static com.henrysgrocery.util.DateValidation.isDiscountValid;

public class AppleDiscount implements Discount {
    private static final LocalDate VALIDATE_FROM = LocalDate.now().plusDays(3);
    private static final LocalDate VALIDATE_TO = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    private static final BigDecimal DISCOUNT_FACTOR = BigDecimal.valueOf(0.10);


    @Override
    public BigDecimal getDiscount(Map<Item, Integer> items, Map.Entry<Item, Integer> discountItem, LocalDate purchaseDate) {

        if (items == null || discountItem == null || purchaseDate == null) {
            return BigDecimal.ZERO;
        }


        if (discountItem.getKey() == APPLE && isDiscountValid(VALIDATE_FROM, VALIDATE_TO, purchaseDate)) {
            return discountItem.getKey().getCost()
                    .multiply(new BigDecimal(discountItem.getValue()))
                    .multiply(DISCOUNT_FACTOR);
        }

        return BigDecimal.ZERO;

    }

}
