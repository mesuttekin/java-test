package com.henrysgrocery.discount

import com.henrysgrocery.item.Item
import spock.lang.Specification

import java.time.LocalDate

import static com.henrysgrocery.item.Item.*

class ApplyDiscountTest extends Specification {

    ApplyDiscount applyDiscount
    Map<Item, Integer> items

    def setup() {
        applyDiscount = new ApplyDiscount()
        items = new EnumMap<Item, Integer>(Item.class)
    }

    def "getDiscount - should get expected discount within valid date"() {

        given:
        def purchaseDate = LocalDate.now().plusDays(3)
        items.put(SOAP, 2)
        items.put(item, quantity)

        expect:
        def discountAmount = applyDiscount.getDiscount(items, items.entrySet()[1], purchaseDate)
        discountAmount == expectedDiscount

        where:
        item    |   quantity    | expectedDiscount
        APPLE   |   1           | 0.01
        MILK    |   1           | 0
        BREAD   |   1           | 0.4

    }
}
