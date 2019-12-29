package com.henrysgrocery.factory;

import com.henrysgrocery.discount.AppleDiscount;
import com.henrysgrocery.discount.BreadDiscount;
import com.henrysgrocery.discount.DefaultDiscount;
import com.henrysgrocery.discount.Discount;
import com.henrysgrocery.item.Item;

import static com.henrysgrocery.item.Item.APPLE;
import static com.henrysgrocery.item.Item.BREAD;

public class DiscountFactory {

    private DiscountFactory() {
        throw new IllegalStateException("Static factory class");
    }

    public static Discount getDiscountInstance(Item discountItem) {

        if (discountItem == APPLE) {

            return new AppleDiscount();
        }

        if (discountItem == BREAD) {

            return new BreadDiscount();
        }

        return new DefaultDiscount();
    }
}
