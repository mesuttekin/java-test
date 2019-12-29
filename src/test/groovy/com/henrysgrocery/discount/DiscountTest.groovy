package com.henrysgrocery.discount

import com.henrysgrocery.item.Item
import spock.lang.Specification

import java.time.LocalDate


class DiscountTest extends Specification {

    def discount
    def items

    def setup() {
        discount = new Discount()
        items = new EnumMap<Item, Integer>(Item.class)
    }

    def "getDiscount - should get 10 percentage  apple discount within valid date"() {

        given:
        def purchaseDate = LocalDate.now().plusDays(3)
        items.put(Item.APPLE, 2)

        when:
        def discountAmount = discount.getDiscount(items.entrySet()[0], purchaseDate)

        then: "should get discount"
        discountAmount == BigDecimal.valueOf(0.02)
    }

    def "getDiscount - should not get apple discount within invalid date"() {

        given:
        def purchaseDate = LocalDate.now()
        items.put(Item.APPLE, 2)

        when:
        def discountAmount = discount.getDiscount(items.entrySet()[0], purchaseDate)

        then: "should get discount"
        discountAmount == BigDecimal.ZERO
    }

    def "getDiscount - should not get any discount for milk"() {

        given:
        def purchaseDate = LocalDate.now().plusDays(3)
        items.put(Item.MILK, 1)

        when:
        def discountAmount = discount.getDiscount(items.entrySet()[0], purchaseDate)

        then: "should get discount"
        discountAmount == BigDecimal.ZERO
    }
}
