package com.henrysgrocery.discount

import com.henrysgrocery.item.Item
import spock.lang.Specification

import java.time.LocalDate

import static com.henrysgrocery.item.Item.*

class AppleDiscountTest extends Specification {

    def discount
    def items

    def setup() {
        discount = new AppleDiscount()
        items = new EnumMap<Item, Integer>(Item.class)
    }

    def "getDiscount - should get 10 percentage apple discount within valid date"() {

        given:
        def purchaseDate = LocalDate.now().plusDays(3)
        items.put(APPLE, appleQuantity)

        expect:
        def discountAmount = discount.getDiscount(items, items.entrySet()[0], purchaseDate)
        discountAmount == expectedDiscount

        where:
        appleQuantity | expectedDiscount
        1             | 0.01
        2             | 0.02
        3             | 0.03

    }

    def "getDiscount - should not get apple discount within invalid date"() {

        given:
        def purchaseDate = LocalDate.now()
        items.put(APPLE, 2)

        when:
        def discountAmount = discount.getDiscount(items, items.entrySet()[0], purchaseDate)

        then: "should get applyDiscount"
        discountAmount == BigDecimal.ZERO
    }
}
