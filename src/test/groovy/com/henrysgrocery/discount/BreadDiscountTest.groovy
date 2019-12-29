package com.henrysgrocery.discount

import com.henrysgrocery.item.Item
import spock.lang.Specification

import java.time.LocalDate

import static com.henrysgrocery.item.Item.BREAD
import static com.henrysgrocery.item.Item.SOAP


class BreadDiscountTest extends Specification {

    def discount
    def items

    def setup() {
        discount = new BreadDiscount()
        items = new EnumMap<Item, Integer>(Item.class)
    }

    def "getDiscount - should get bread discount when there are soup in the cart within valid date"() {

        given:
        def purchaseDate = LocalDate.now().plusDays(3)
        items.put(SOAP, soupQuantity)
        items.put(BREAD, breadQuantity)


        expect:
        def discountAmount = discount.getDiscount(items, items.entrySet()[1], purchaseDate)
        discountAmount == expectedDiscount

        where:
        soupQuantity | breadQuantity | expectedDiscount
        4            | 1             | 0.40
        2            | 1             | 0.40
        1            | 1             | 0
        4            | 2             | 0.80
        8            | 1             | 0.40
    }

    def "getDiscount - should not get bread discount when there are 2 soup in the cart within invalid date"() {

        given:
        def purchaseDate = LocalDate.now().minusDays(2)
        items.put(SOAP, 2)
        items.put(BREAD, 1)


        when:
        def discountAmount = discount.getDiscount(items, items.entrySet()[1], purchaseDate)

        then: "should get applyDiscount"
        discountAmount == BigDecimal.ZERO
    }

    def "getDiscount - should not get bread discount when there is no soup in the cart within valid date"() {

        given:
        def purchaseDate = LocalDate.now()
        items.put(BREAD, 1)


        when:
        def discountAmount = discount.getDiscount(items, items.entrySet()[0], purchaseDate)

        then: "should get applyDiscount"
        discountAmount == BigDecimal.ZERO
    }

    def "getDiscount - should not get any discount when parameters are null"() {

        when:
        def discountAmount = discount.getDiscount(null, null, null)

        then: "should get applyDiscount"
        discountAmount == BigDecimal.ZERO
    }
}
