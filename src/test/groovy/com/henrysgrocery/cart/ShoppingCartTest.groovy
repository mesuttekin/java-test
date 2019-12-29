package com.henrysgrocery.cart

import com.henrysgrocery.item.Item
import spock.lang.Specification

import java.time.LocalDate

import static com.henrysgrocery.item.Item.*

class ShoppingCartTest extends Specification {

    ShoppingCart shoppingCart

    def setup() {
        def purchaseDate = LocalDate.now().plusDays(3)
        shoppingCart = new ShoppingCart(purchaseDate)
    }

    def "getItems - should not throw any exception and return empty map"() {

        when:
        def items = shoppingCart.getItems()

        then: "should not throw an exception and return empty map"
        true
        items.size() == 0

    }

    def "addItem - should add a new item in cart and get added item"() {

        given:
        Item item = MILK

        when:
        shoppingCart.addCart(item)

        then: "should not throw an exception and get the item"
        true
        def items = shoppingCart.getItems()
        items.containsKey(item)
    }

    def "addItem - should add an existing item in cart and increase quantity of it "() {

        given:
        Item item = MILK
        shoppingCart.addCart(item)

        when:
        shoppingCart.addCart(item)

        then: "should get added items"
        def items = shoppingCart.getItems()
        items.containsKey(item)
        items.get(item) == 2
    }

    def "addItem - should add different items"() {

        given:
        shoppingCart.addCart(MILK)

        when:
        shoppingCart.addCart(BREAD)
        shoppingCart.addCart(SOUP)
        shoppingCart.addCart(APPLE)

        then: "should get added items"
        def items = shoppingCart.getItems()
        items.containsKey(MILK)
        items.containsKey(BREAD)
        items.containsKey(SOUP)
        items.containsKey(APPLE)
    }

    def "getTotal - should get total of cost"() {

        given: "a tin of soup, a loaf of bread, a bottle of milk and 2 apples"
        shoppingCart.addCart(SOUP)
        shoppingCart.addCart(BREAD)
        shoppingCart.addCart(MILK)

        when:
        BigDecimal total = shoppingCart.getTotal()

        then: "should get total of items"
        total == BigDecimal.valueOf(2.75)
    }

    def "getTotal - should return 0 when shopping cart is empty"() {

        when:
        BigDecimal total = shoppingCart.getTotal()

        then: "should get zero"
        total == BigDecimal.ZERO
    }

    def "getTotal - should get total of cost with 10 percentage apple discount"() {

        given: "two apples added to cart"
        shoppingCart.addCart(APPLE, appleQuantity)

        expect:
        BigDecimal total = shoppingCart.getTotal()
        total == expectedTotal

        where:
        appleQuantity | expectedTotal
                1     |     0.09        // 0.01 applyDiscount
                2     |     0.18        // 0.02 applyDiscount
                3     |     0.27        // 0.03 applyDiscount

    }

    def "getTotal - should get total of cost with bread discount"() {

        given: "two tins of soup and a loaf of bread"
        shoppingCart.addCart(SOUP, soupQuantity)
        shoppingCart.addCart(BREAD, breadQuantity)


        expect:
        def total = shoppingCart.getTotal()
        total == expectedTotal

        where:
        soupQuantity    | breadQuantity | expectedTotal
                4       |        1      |      3            // 0.40 applyDiscount
                2       |        1      |      1.70         // 0.40 applyDiscount
                1       |        1      |      1.45         // 0 applyDiscount
                4       |        2      |      3.40         // 0.80 applyDiscount
                8       |        1      |      5.6          // 0.40 applyDiscount
    }


}
