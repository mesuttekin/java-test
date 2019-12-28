package com.henrysgrocery.cart

import spock.lang.Specification


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
        String item = "Milk"

        when:
        shoppingCart.addCart(item)

        then: "should not throw an exception and get the item"
        true
        def items = shoppingCart.getItems()
        items.containsKey(item)
    }

    def "addItem - should add an existing item in cart and increase quantity of it "() {

        given:
        String item = "Milk"
        shoppingCart.addCart(item)

        when:
        shoppingCart.addCart(item)

        then: "should get added items"
        def items = shoppingCart.getItems()
        items.containsKey(item)
        items.get(item) == 2
    }




}
