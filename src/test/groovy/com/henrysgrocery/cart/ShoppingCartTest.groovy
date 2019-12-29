package com.henrysgrocery.cart

import com.henrysgrocery.item.Item
import spock.lang.Specification

import static com.henrysgrocery.item.Item.APPLE
import static com.henrysgrocery.item.Item.BREAD
import static com.henrysgrocery.item.Item.MILK
import static com.henrysgrocery.item.Item.SOAP


class ShoppingCartTest extends Specification {

    ShoppingCart shoppingCart

    def setup() {
        shoppingCart = new ShoppingCart()
    }

    def "getItems - should not throw any exception and return empty map"() {

        given:
        shoppingCart = new ShoppingCart()

        when:
        Map<String, Integer> items = shoppingCart.getItems()

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
        shoppingCart.addCart(SOAP)
        shoppingCart.addCart(APPLE)

        then: "should get added items"
        def items = shoppingCart.getItems()
        items.containsKey(MILK)
        items.containsKey(BREAD)
        items.containsKey(SOAP)
        items.containsKey(APPLE)
    }

    def "getTotal - should get total of cost"() {

        given: "a tin of soap, a loaf of bread, a bottle of milk and 2 apples"
        shoppingCart.addCart(SOAP)
        shoppingCart.addCart(BREAD)
        shoppingCart.addCart(MILK)

        when:
        BigDecimal total = shoppingCart.getTotal()

        then: "should get added items"
        total == BigDecimal.valueOf(2.75)
    }

    def "getTotal - should return 0 when shopping cart is empty"() {

        when:
        BigDecimal total = shoppingCart.getTotal()

        then: "should get added items"
        total == BigDecimal.ZERO
    }


}
